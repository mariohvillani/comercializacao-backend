package com.totvs.componente.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum UnidadeMedidaEnum {

    SC(0, "Saca"),
    TN(1, "Tonelada"),
    BU(2, "Bushel"),
    KG(3, "Quilo");

    private final Integer codigo;
    private final String descricao;

    UnidadeMedidaEnum(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    UnidadeMedidaEnum getByCodigo(Integer codigo) {
        return Arrays.stream(UnidadeMedidaEnum.values())
                .filter(obj -> obj.getCodigo().equals(codigo))
                .findFirst().orElse(null);
    }

}
