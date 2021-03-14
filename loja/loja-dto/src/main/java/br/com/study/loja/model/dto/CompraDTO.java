package br.com.study.loja.model.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class CompraDTO {

    private List<ItemCompraDTO> itens;

    private EnderecoDTO endereco;

}
