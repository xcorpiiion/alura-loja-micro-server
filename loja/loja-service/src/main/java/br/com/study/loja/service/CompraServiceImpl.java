package br.com.study.loja.service;

import br.com.study.loja.dto.CompraDTO;
import br.com.study.loja.dto.InfoFornecedorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.HttpMethod.GET;

@Service
public class CompraServiceImpl implements CompraService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void realizaCompra(CompraDTO compraDTO) {
        this.restTemplate.exchange("http://localhost:8081/info/" + compraDTO.getEndereco().getEstato(),
                GET, null, InfoFornecedorDTO.class);
    }
}
