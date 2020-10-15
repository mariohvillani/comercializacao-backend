package com.totvs.componente.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum AplicacaoEnum {

    C(0, "Compra"),
    V(1, "Venda"),
    A(2, "Ambos");

    private final Integer codigo;
    private final String descricao;

    AplicacaoEnum(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    AplicacaoEnum getByCodigo(Integer codigo) {
        return Arrays.stream(AplicacaoEnum.values())
                .filter(obj -> obj.getCodigo().equals(codigo))
                .findFirst().orElse(null);
    }

}
