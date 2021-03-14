package br.com.study.loja.model.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class VoucherDTO {

    private Long numero;

    private LocalDate previsaoParaEntrega;

}
