package br.com.study.loja.model.controller;

import br.com.study.loja.model.Compra;
import br.com.study.loja.model.dto.CompraDTO;
import br.com.study.loja.model.service.CompraService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/compras")
public class CompraController {

    @Getter
    @Autowired
    private CompraService compraService;

    @PostMapping
    public ResponseEntity<Compra> realizaCompra(@RequestBody CompraDTO compraDTO) {
        Compra compra = this.compraService.realizaCompra(compraDTO);
        return ok(compra);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Compra> findById(@PathVariable Long id) {
        return this.getCompraService().findById(id);
    }

}
