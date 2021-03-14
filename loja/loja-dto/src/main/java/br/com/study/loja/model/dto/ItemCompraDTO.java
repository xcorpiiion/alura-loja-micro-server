package br.com.study.loja.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ItemCompraDTO {

    private Long id;

    private Integer quantidade;

}
