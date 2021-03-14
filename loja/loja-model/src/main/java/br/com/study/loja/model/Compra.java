package br.com.study.loja.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@Entity(name = "loja")
public class Compra {

    @Id
    private Long pedidoId;

    private Integer tempoPreparo;

    private String enderecoDestino;

}
