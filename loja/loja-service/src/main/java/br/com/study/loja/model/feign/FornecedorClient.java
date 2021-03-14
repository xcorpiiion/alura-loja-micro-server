package br.com.study.loja.model.feign;

import br.com.study.loja.model.dto.InfoPedidoDTO;
import br.com.study.loja.model.dto.InfoFornecedorDTO;
import br.com.study.loja.model.dto.ItemCompraDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "fornecedor")
public interface FornecedorClient {

    @GetMapping("/infos/{estado}")
    InfoFornecedorDTO getInfoByEstado(@PathVariable() String estado);

    @PostMapping("/pedidos")
    InfoPedidoDTO realizaPedido(List<ItemCompraDTO> itens);

}
