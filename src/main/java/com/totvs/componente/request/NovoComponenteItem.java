package com.totvs.componente.request;

import com.totvs.componente.model.Componente;
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
public class NovoComponenteItem implements Serializable {

    private static final long serialVersionUID = -1225017865506157959L;

    private Integer id;

    @NotBlank(message = "O código não pode estar em branco")
    private String codigo;

    @NotBlank(message = "A descricao não pode estar em branco")
    private String descricao;

    @NotNull(message = "O id do componente não pode ser nulo")
    private Integer idComponente;

    public ComponenteItem toEntity() {
        return ComponenteItem.builder()
                .id(this.getId())
                .codigo(this.getCodigo())
                .descricao(this.getDescricao())
                .componente(Componente.builder().id(this.getIdComponente()).build())
                .build();
    }
}
