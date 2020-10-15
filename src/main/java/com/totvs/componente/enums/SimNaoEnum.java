package com.totvs.componente.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum SimNaoEnum {

    N(0, "Não"),
    S(1, "Sim");

    private final Integer codigo;
    private final String descricao;

    SimNaoEnum(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    SimNaoEnum getByCodigo(Integer codigo) {
        return Arrays.stream(SimNaoEnum.values())
                .filter(obj -> obj.getCodigo().equals(codigo))
                .findFirst().orElse(null);
    }
}
