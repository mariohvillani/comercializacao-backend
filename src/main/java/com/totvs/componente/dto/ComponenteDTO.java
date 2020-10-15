package com.totvs.componente.dto;

import com.totvs.componente.model.Componente;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComponenteDTO implements Serializable {

    private static final long serialVersionUID = 6334986637494313887L;

    private Integer id;

    @NotBlank(message = "O Código não pode ser nulo")
    private String codigo;

    @NotBlank(message = "A descrição não pode estar em branco")
    private String descricao;

    private String codigoExterno;

    @NotBlank(message = "A tabela não pode estar em branco")
    private String tabela;

    @NotNull(message = "Unidade Medida não pode ser nulo")
    private Integer unidadeMedida;

    @NotNull(message = "Moeda não pode ser nulo")
    private Integer moeda;

    @NotNull(message = "Tipo não pode ser nulo")
    private Integer tipo;

    @NotNull(message = "Aplicação não pode ser nulo")
    private Integer aplicacao;

    @NotNull(message = "Ativo não pode ser nulo")
    private Integer ativo;

    @NotNull(message = "Hedge não pode ser nulo")
    private Integer hedge;

    private Integer edit;

    public static ComponenteDTO from(Componente componente) {
        return ComponenteDTO.builder()
                .id(componente.getId())
                .codigo(componente.getCodigo())
                .descricao(componente.getDescricao())
                .codigoExterno(componente.getCodigoExterno())
                .tabela(componente.getTabela())
                .unidadeMedida(componente.getUnidadeMedida() != null ? componente.getUnidadeMedida().getCodigo() : null)
                .moeda(componente.getMoeda() != null ? componente.getMoeda().getCodigo() : null)
                .tipo(componente.getTipo() != null ? componente.getTipo().getCodigo() : null)
                .aplicacao(componente.getAplicacao() != null ? componente.getAplicacao().getCodigo() : null)
                .ativo(componente.getAtivo() != null ? componente.getAtivo().getCodigo() : null)
                .hedge(componente.getHedge() != null ? componente.getHedge().getCodigo() : null)
                .edit(1)
                .build();
    }
}
