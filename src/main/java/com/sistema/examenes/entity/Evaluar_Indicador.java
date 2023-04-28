package com.sistema.examenes.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "evaluar_indicador")
public class Evaluar_Indicador implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Evaluar_Indicador")
    private Long id_Evaluar_Indicador;

    private double valor;

    @ManyToOne(fetch = FetchType.EAGER)
    private Indicador indicador;
    @ManyToOne(fetch = FetchType.EAGER)
    private Formula formula;
    @ManyToOne(fetch = FetchType.EAGER)
    private Cuantitativa cuantitativa;
}
