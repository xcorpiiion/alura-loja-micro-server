package br.com.study.fornecedor.service;

import br.com.study.fornecedor.model.Info;
import org.springframework.stereotype.Service;

@Service
public interface InfoService {

    Info getInfoService(String estado);

}
