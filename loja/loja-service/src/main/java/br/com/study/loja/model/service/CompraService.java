package br.com.study.loja.model.service;

import br.com.study.loja.model.Compra;
import br.com.study.loja.model.dto.CompraDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface CompraService {

    Compra realizaCompra(CompraDTO compraDTO);

    ResponseEntity<Compra> findById(Long id);

}
