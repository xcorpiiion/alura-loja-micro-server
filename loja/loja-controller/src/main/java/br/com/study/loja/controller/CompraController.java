package br.com.study.loja.controller;

import br.com.study.loja.Compra;
import br.com.study.loja.dto.CompraDTO;
import br.com.study.loja.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compras")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @PostMapping
    public ResponseEntity<Compra> realizaCompra(@RequestBody CompraDTO compraDTO) {
        Compra compra = this.compraService.realizaCompra(compraDTO);
        return ResponseEntity.ok(compra);
    }

}
