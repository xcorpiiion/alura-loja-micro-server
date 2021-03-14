package br.com.study.loja.model.feign;

import br.com.study.loja.model.dto.InfoEntregaDTO;
import br.com.study.loja.model.dto.VoucherDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "transportador")
public interface TransportadorClient {

    @PostMapping("/entregas")
    VoucherDTO reservaEntrega(InfoEntregaDTO infoEntregaDTO);

}
