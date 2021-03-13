package br.com.study.loja.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class InfoPedidoDTO {

    private Long id;

    private Integer tempoDePreparo;

}
