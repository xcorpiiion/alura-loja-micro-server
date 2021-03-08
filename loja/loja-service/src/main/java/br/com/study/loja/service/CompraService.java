package br.com.study.loja.service;

import br.com.study.loja.dto.CompraDTO;
import org.springframework.stereotype.Service;

@Service
public interface CompraService {

    void realizaCompra(CompraDTO compraDTO);

}
