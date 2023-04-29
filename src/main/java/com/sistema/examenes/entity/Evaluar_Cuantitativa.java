package com.sistema.examenes.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "evaluar_indicador")
public class Evaluar_Cuantitativa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evaluar_cuantitativa")
    private Long id_evaluar_cuantitativa;

    private double valor;

    @ManyToOne(fetch = FetchType.EAGER)
    private Encabezado_Evaluar encabezado_evaluar;

    @ManyToOne(fetch = FetchType.EAGER)
    private Cuantitativa cuantitativa;
}
