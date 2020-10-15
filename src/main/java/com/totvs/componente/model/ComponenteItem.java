package com.totvs.componente.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "componente_item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComponenteItem implements Serializable {

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
