package br.com.study.fornecedor.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class ItemDoPedidoDTO {

	private long id;
	
	private int quantidade;
	
}
