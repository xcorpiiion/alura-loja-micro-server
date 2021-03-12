package br.com.study.fornecedor.service;

import br.com.study.fornecedor.model.Info;
import br.com.study.fornecedor.repository.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoServiceImpl implements InfoService {

    @Autowired
    private InfoRepository infoRepository;

    @Override
    public Info getInfoService(String estado) {
        return this.infoRepository.findByEstado(estado);
    }
}
