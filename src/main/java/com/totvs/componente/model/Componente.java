package com.totvs.componente.model;

import com.totvs.componente.enums.*;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "componente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Componente implements Serializable {

    private static final long serialVersionUID = -6636555522470313904L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "O código não pode estar em branco")
    @Column(name = "codigo", unique = true, nullable = false)
    private String codigo;

    @NotBlank(message = "A descrição não pode estar em branco")
    @Column(name = "descricao")
    private String descricao;

    @Column(name = "codigo_externo")
    private String codigoExterno;

    @NotBlank(message = "A tabela não pode estar em branco")
    @Column(name = "tabela")
    private String tabela;

    @NotNull
    @Enumerated
    @Column(name = "unidade_medida")
    private UnidadeMedidaEnum unidadeMedida;

    @NotNull
    @Enumerated
    @Column(name = "moeda")
    private MoedaEnum moeda;

    @NotNull
    @Enumerated
    @Column(name = "tipo")
    private TipoEnum tipo;

    @NotNull
    @Enumerated
    @Column(name = "aplicacao")
    private AplicacaoEnum aplicacao;

    @NotNull
    @Enumerated
    @Column(name = "ativo")
    private SimNaoEnum ativo;

    @NotNull
    @Enumerated
    @Column(name = "hedge")
    private SimNaoEnum hedge;
}
