package com.totvs.componente.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "componente_componentes")
@Getter
@Setter
@NoArgsConstructor
public class ComponenteComponentes implements Serializable {

    private static final long serialVersionUID = -8538366306790083706L;

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
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "componente_id")
    private Componente componente;

}
