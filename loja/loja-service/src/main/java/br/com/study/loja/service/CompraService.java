package br.com.study.loja.service;

import br.com.study.loja.Compra;
import br.com.study.loja.dto.CompraDTO;
import org.springframework.stereotype.Service;

@Service
public interface CompraService {

    Compra realizaCompra(CompraDTO compraDTO);

}
