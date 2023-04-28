package com.sistema.examenes.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "cualitativa")
public class Cualitativa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cualitativa")
    private Long id_cualitativa;
    private double valor;
    private String escala;

    @ManyToOne(fetch = FetchType.EAGER)
    private Indicador indicador;

}
