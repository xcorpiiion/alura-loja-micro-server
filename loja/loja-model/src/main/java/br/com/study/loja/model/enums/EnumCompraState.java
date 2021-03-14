package br.com.study.loja.model.enums;

import lombok.Getter;

@Getter
public enum EnumCompraState {

    RECEBIDO("Recebido"),
    PEDIDO_REALIZADO("Pedido realizado"),
    RESERVA_ENTREGA_REALIZADA("Reserva da entrega realizada");

    EnumCompraState(String recebido) {
    }


}
