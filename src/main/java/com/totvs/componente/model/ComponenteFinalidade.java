package com.totvs.componente.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "componente_finalidade")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComponenteFinalidade implements Serializable {

    private static final long serialVersionUID = -1713676408105273108L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "O código não pode estar em branco")
    @Column(name = "codigo")
    private String codigo;

    @NotBlank(message = "A descricao não pode estar em branco")
    @Column(name = "descricao")
    private String descricao;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "componente_id")
    private Componente componente;
}
