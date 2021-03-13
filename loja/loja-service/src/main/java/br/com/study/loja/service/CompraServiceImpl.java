package br.com.study.loja.service;

import br.com.study.loja.Compra;
import br.com.study.loja.dto.CompraDTO;
import br.com.study.loja.dto.InfoFornecedorDTO;
import br.com.study.loja.dto.InfoPedidoDTO;
import br.com.study.loja.feign.FornecedorClient;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CompraServiceImpl implements CompraService {

    @Getter
    @Autowired
    private FornecedorClient fornecedorClient;

    @Override
    public Compra realizaCompra(CompraDTO compraDTO) {
        log.info("Iniciando a realização da compra.");
        InfoFornecedorDTO info = this.getFornecedorClient().getInfoByEstado(compraDTO.getEndereco().getEstado());
        log.info("Info fornecedor encontrado");
        InfoPedidoDTO infoPedidoDTO = this.getFornecedorClient().realizaPedido(compraDTO.getItens());
        Compra compra = new Compra(infoPedidoDTO.getId(), infoPedidoDTO.getTempoDePreparo(), compraDTO.getEndereco().toString());
        log.info("Compra realizada");
        return compra;
    }
}
