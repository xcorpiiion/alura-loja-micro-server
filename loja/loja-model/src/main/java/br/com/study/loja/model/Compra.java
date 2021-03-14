package br.com.study.loja.model;

import br.com.study.loja.model.enums.EnumCompraState;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@Entity(name = "loja")
public class Compra {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private Long pedidoId;

    private Integer tempoPreparo;

    private String enderecoDestino;

    private LocalDate previsaoParaEntrega;

    private Long numeroVoucher;

    @Enumerated(STRING)
    private EnumCompraState enumCompraState;

}
