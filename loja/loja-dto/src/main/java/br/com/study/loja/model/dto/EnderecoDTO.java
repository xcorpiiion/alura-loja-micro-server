package br.com.study.loja.model.dto;

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
