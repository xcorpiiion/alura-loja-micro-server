package br.com.study.loja.model.dto;

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
