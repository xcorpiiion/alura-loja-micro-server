package br.com.study.transportadora.model;

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
