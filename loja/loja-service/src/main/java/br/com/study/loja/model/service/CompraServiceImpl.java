package br.com.study.loja.model.service;

import br.com.study.loja.model.Compra;
import br.com.study.loja.model.dto.InfoPedidoDTO;
import br.com.study.loja.model.feign.FornecedorClient;
import br.com.study.loja.model.dto.CompraDTO;
import br.com.study.loja.model.dto.InfoFornecedorDTO;
import br.com.study.loja.model.repository.CompraRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.notFound;

@Slf4j
@Service
public class CompraServiceImpl implements CompraService {

    @Getter
    @Autowired
    private FornecedorClient fornecedorClient;

    @Getter
    @Autowired
    private CompraRepository repository;

    @HystrixCommand(fallbackMethod = "realizaCompraFallback", threadPoolKey = "realizaCompraThreadPoll")
    @Override
    public Compra realizaCompra(CompraDTO compraDTO) {
        log.info("Iniciando a realização da compra.");
        String estado = compraDTO.getEndereco().getEstado();
        log.info("Buscando informações do fornecedor de {}", estado);
        InfoFornecedorDTO info = this.getFornecedorClient().getInfoByEstado(estado);
        log.info("Realizando um Pedido.");
        InfoPedidoDTO infoPedidoDTO = this.getFornecedorClient().realizaPedido(compraDTO.getItens());
        Compra compra = new Compra(infoPedidoDTO.getId(), infoPedidoDTO.getTempoDePreparo(), compraDTO.getEndereco().toString());
        this.getRepository().save(compra);
        log.info("Compra realizada");
        return compra;
    }

    @HystrixCommand(threadPoolKey = "findByIdThreadPoll")
    @Override
    public ResponseEntity<Compra> findById(Long id) {
        Optional<Compra> compra = this.getRepository().findById(id);
        return compra.map(ResponseEntity::ok).orElseGet(() -> noContent().build());
    }

    public Compra realizaCompraFallback(CompraDTO compraDTO) {
        Compra compra = new Compra();
        compra.setEnderecoDestino(compraDTO.getEndereco().toString());
        return compra;
    }
}
