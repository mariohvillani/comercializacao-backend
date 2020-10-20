package com.totvs.componente.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.totvs.componente.model.ComponenteFinalidade;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComponenteFinalidadeDTO implements Serializable {

    private static final long serialVersionUID = -1649852935074715649L;

    private Integer id;

    @NotBlank(message = "O código não pode estar em branco")
    private String codigo;

    @NotBlank(message = "A descricao não pode estar em branco")
    private String descricao;

    @NotNull(message = "O id do componente não pode ser nulo")
    private Integer idComponente;

    public static ComponenteFinalidadeDTO from(ComponenteFinalidade componenteFinalidade) {
        return ComponenteFinalidadeDTO.builder()
                .id(componenteFinalidade.getId())
                .codigo(componenteFinalidade.getCodigo())
                .descricao(componenteFinalidade.getDescricao())
                .idComponente(componenteFinalidade.getComponente() != null ?
                        componenteFinalidade.getComponente().getId() :null)
                .build();
    }
}
