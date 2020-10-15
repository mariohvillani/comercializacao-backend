package com.totvs.componente.dto;

import com.totvs.componente.model.ComponenteItem;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComponenteItemDTO implements Serializable {

    private static final long serialVersionUID = -1649852935074715649L;

    private Integer id;

    @NotBlank(message = "O código não pode estar em branco")
    private String codigo;

    @NotBlank(message = "A descricao não pode estar em branco")
    private String descricao;

    @NotNull(message = "O id do componente não pode ser nulo")
    private Integer idComponente;

    public static ComponenteItemDTO from(ComponenteItem componenteItem) {
        return ComponenteItemDTO.builder()
                .id(componenteItem.getId())
                .codigo(componenteItem.getCodigo())
                .descricao(componenteItem.getDescricao())
                .idComponente(componenteItem.getComponente() != null ?
                        componenteItem.getComponente().getId() :null)
                .build();
    }
}
