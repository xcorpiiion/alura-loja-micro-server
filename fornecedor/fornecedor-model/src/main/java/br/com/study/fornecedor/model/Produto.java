package br.com.study.fornecedor.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;
	
	private String nome;
	
	private String estado;
	
	private String descricao;
	
	private BigDecimal preco;
	
}
