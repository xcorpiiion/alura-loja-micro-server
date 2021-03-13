package br.com.study.fornecedor.configuration;

import br.com.study.fornecedor.dto.ItemDoPedidoDTO;
import br.com.study.fornecedor.model.Pedido;
import br.com.study.fornecedor.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<Pedido> realizaPedido(@RequestBody List<ItemDoPedidoDTO> produtos) {
        return ok(pedidoService.realizaPedido(produtos));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getPedidoPorId(@PathVariable Long id) {
        Pedido pedidoPorId = pedidoService.getPedidoPorId(id);
        if(pedidoPorId == null) {
            return notFound().build();
        }
        return ok(pedidoPorId);
    }
}
