package com.totvs.componente.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum TipoEnum {

    PC(0, "Preço Calculado"),
    PP(1, "Preço Proposto"),
    IN(2, "Informativo"),
    MG(3, "Margem");

    private final Integer codigo;
    private final String descricao;

    TipoEnum(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    TipoEnum getByCodigo(Integer codigo) {
        return Arrays.stream(TipoEnum.values())
                .filter(obj -> obj.getCodigo().equals(codigo))
                .findFirst().orElse(null);
    }

}
