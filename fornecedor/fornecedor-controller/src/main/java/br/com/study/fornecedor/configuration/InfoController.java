package br.com.study.fornecedor.configuration;

import br.com.study.fornecedor.model.Info;
import br.com.study.fornecedor.service.InfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@Slf4j
@RestController
@RequestMapping("/infos")
public class InfoController {

    @Autowired
    private InfoService infoService;

    @GetMapping("/{estado}")
    public ResponseEntity<Info> getInfoByEstado(@PathVariable() String estado) {
        log.info("Recebido pedido de informações do fornecedor de {}.", estado);
        Info infoFornecedor = this.infoService.getInfoService(estado);
        return ok(infoFornecedor);
    }

}
