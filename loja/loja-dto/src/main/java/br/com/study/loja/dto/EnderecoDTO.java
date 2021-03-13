package br.com.study.loja.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class EnderecoDTO {

    private String rua;

    private int numero;

    private String estado;

}
