package br.com.study.loja;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class Compra {

    private Long pedidoId;

    private Integer tempoPreparo;

    private String enderecoDestino;

}
