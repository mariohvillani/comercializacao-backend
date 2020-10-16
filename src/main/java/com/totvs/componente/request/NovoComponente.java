package com.totvs.componente.request;

import com.totvs.componente.enums.*;
import com.totvs.componente.model.Componente;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
public class NovoComponente implements Serializable {

    private static final long serialVersionUID = 707240391209107253L;

    private Integer id;

    @NotBlank(message = "{NovoComponente.codigo.NotBlank}")
    private String codigo;

    @NotBlank(message = "A descrição não pode estar em branco")
    private String descricao;

    private String codigoExterno;

    @NotBlank(message = "A tabela não pode estar em branco")
    private String tabela;

    @NotNull(message = "Unidade Medida não pode ser nulo")
    private UnidadeMedidaEnum unidadeMedida;

    @NotNull(message = "Moeda não pode ser nulo")
    private MoedaEnum moeda;

    @NotNull(message = "Tipo não pode ser nulo")
    private TipoEnum tipo;

    @NotNull(message = "Aplicação não pode ser nulo")
    private AplicacaoEnum aplicacao;

    @NotNull(message = "Ativo não pode ser nulo")
    private SimNaoEnum ativo;

    @NotNull(message = "Hedge não pode ser nulo")
    private SimNaoEnum hedge;

    public Componente toEntity() {

        return Componente.builder()
                .id(this.id)
                .codigo(this.codigo)
                .descricao(this.descricao)
                .codigoExterno(this.codigoExterno)
                .tabela(this.tabela)
                .unidadeMedida(this.unidadeMedida)
                .moeda(this.moeda)
                .tipo(this.tipo)
                .aplicacao(this.aplicacao)
                .ativo(this.ativo)
                .hedge(this.hedge)
                .build();
    }

}
