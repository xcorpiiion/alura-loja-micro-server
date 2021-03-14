package br.com.study.loja.model.service;

import br.com.study.loja.model.Compra;
import br.com.study.loja.model.dto.*;
import br.com.study.loja.model.enums.EnumCompraState;
import br.com.study.loja.model.feign.FornecedorClient;
import br.com.study.loja.model.feign.TransportadorClient;
import br.com.study.loja.model.repository.CompraRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

import static br.com.study.loja.model.enums.EnumCompraState.*;
import static org.springframework.http.ResponseEntity.noContent;

@Slf4j
@Service
public class CompraServiceImpl implements CompraService {

    @Getter
    @Autowired
    private FornecedorClient fornecedorClient;

    @Getter
    @Autowired
    private TransportadorClient transportadorClient;

    @Getter
    @Autowired
    private CompraRepository repository;

    @HystrixCommand(fallbackMethod = "realizaCompraFallback", threadPoolKey = "realizaCompraThreadPoll")
    @Override
    public Compra realizaCompra(CompraDTO compraDTO) {
        log.info("Iniciando a realização da compra.");
        Compra compra = new Compra();
        this.salvaSituacaoCompra(RECEBIDO, compra, compraDTO);

        InfoFornecedorDTO fornecedorDTO = this.buscaInformacaoFornecedor(compraDTO);
        InfoPedidoDTO pedidoDTO = this.getFornecedorClient().realizaPedido(compraDTO.getItens());
        InfoEntregaDTO entregaDTO = new InfoEntregaDTO();
        this.salvaSituacaoCompra(PEDIDO_REALIZADO, compra, compraDTO);

        this.criaEntrega(compraDTO, fornecedorDTO, pedidoDTO, entregaDTO);
        VoucherDTO voucherDTO = this.getTransportadorClient().reservaEntrega(entregaDTO);
        this.salvaSituacaoCompra(RESERVA_ENTREGA_REALIZADA, compra, compraDTO);

        compra = this.savePedido(compraDTO, pedidoDTO, voucherDTO, compra);
        log.info("Compra realizada");
        return compra;
    }

    private void salvaSituacaoCompra(EnumCompraState compraState, Compra compra, CompraDTO compraDTO) {
        compra.setEnumCompraState(compraState);
        compra = this.getRepository().save(compra);
        log.info("Compra teve sua situação alterada para: {}", compra.getEnumCompraState());
        compraDTO.setCompraId(compra.getId());
    }

    private void criaEntrega(CompraDTO compraDTO, InfoFornecedorDTO fornecedorDTO, InfoPedidoDTO pedidoDTO, InfoEntregaDTO entregaDTO) {
        log.info("Criando entrega do pedido");
        entregaDTO.setPedidoId(pedidoDTO.getId());
        entregaDTO.setDataParaEntrega(LocalDate.now().plusDays(pedidoDTO.getTempoDePreparo()));
        entregaDTO.setEnderecoOrigem(fornecedorDTO.getEndereco());
        entregaDTO.setEnderecoDestino(compraDTO.getEndereco().toString());
        log.info("Entrega criada: {}", entregaDTO.toString());
    }

    private Compra savePedido(CompraDTO compraDTO, InfoPedidoDTO infoPedidoDTO, VoucherDTO voucherDTO, Compra compra) {
        log.info("Realizando um Pedido.");
        compra = new Compra(compra.getId(), infoPedidoDTO.getId(), infoPedidoDTO.getTempoDePreparo(),
                compraDTO.getEndereco().toString(), voucherDTO.getPrevisaoParaEntrega(), voucherDTO.getNumero(),
                compra.getEnumCompraState());
        this.getRepository().save(compra);
        log.info("Compra salva: {}", compra.toString());
        return compra;
    }

    private InfoFornecedorDTO buscaInformacaoFornecedor(CompraDTO compraDTO) {
        String estado = compraDTO.getEndereco().getEstado();
        log.info("Buscando informações do fornecedor de {}", estado);
        return this.getFornecedorClient().getInfoByEstado(estado);
    }

    @HystrixCommand(threadPoolKey = "findByIdThreadPoll")
    @Override
    public ResponseEntity<Compra> findById(Long id) {
        log.info("Buscando compra pelo id");
        Optional<Compra> compra = this.getRepository().findById(id);
        return compra.map(ResponseEntity::ok).orElseGet(() -> noContent().build());
    }

    public Compra realizaCompraFallback(CompraDTO compraDTO) {
        if (compraDTO.getCompraId() != null) {
            return this.findById(compraDTO.getCompraId()).getBody();
        }
        Compra compra = new Compra();
        compra.setEnderecoDestino(compraDTO.getEndereco().toString());
        return compra;
    }
}
