package br.com.study.transportadora.controller;

import br.com.study.transportadora.model.EntregaDTO;
import br.com.study.transportadora.model.VoucherDTO;
import br.com.study.transportadora.service.EntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entrega")
public class EntregaController {
	
	@Autowired
	private EntregaService entregaService;

	@PostMapping
	public ResponseEntity<VoucherDTO> reservaEntrega(@RequestBody EntregaDTO pedidoDTO) {
		return  entregaService.reservaEntrega(pedidoDTO);
	}
}
