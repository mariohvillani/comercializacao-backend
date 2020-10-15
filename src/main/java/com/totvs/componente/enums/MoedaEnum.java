package com.totvs.componente.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum MoedaEnum {

    BRL(0, "Real"),
    USD(1, "Dolar");

    private final Integer codigo;
    private final String descricao;

    MoedaEnum(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    MoedaEnum getByCodigo(Integer codigo) {
        return Arrays.stream(MoedaEnum.values())
                .filter(obj -> obj.getCodigo().equals(codigo))
                .findFirst().orElse(null);
    }

}
