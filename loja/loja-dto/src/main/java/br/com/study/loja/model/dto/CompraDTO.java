package br.com.study.loja.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class CompraDTO {

    @JsonIgnore
    private Long compraId;

    private List<ItemCompraDTO> itens;

    private EnderecoDTO endereco;

}
