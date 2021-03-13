package br.com.study.fornecedor.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

import static br.com.study.fornecedor.model.EnumPedidoStatus.RECEBIDO;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;
	
	private Integer tempoDePreparo;
	
	@Enumerated(STRING)
	private EnumPedidoStatus status;
	
	@OneToMany
	@JoinColumn(name = "pedidoId")
	private List<PedidoItem> itens;
	
	public Pedido(List<PedidoItem> itens) {
		this.itens = itens;
		this.status = RECEBIDO;
	}
}
