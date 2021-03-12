package br.com.study.fornecedor.controller;

import br.com.study.fornecedor.model.Info;
import br.com.study.fornecedor.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/infos")
public class InfoController {

    @Autowired
    private InfoService infoService;

    @GetMapping("/{estado}")
    public ResponseEntity<Info> getInfoByEstado(@PathVariable() String estado) {
        Info infoFornecedor = this.infoService.getInfoService(estado);
        return ok(infoFornecedor);
    }

}
