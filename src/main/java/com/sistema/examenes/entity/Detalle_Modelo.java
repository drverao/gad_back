package com.sistema.examenes.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "detalle_modelo")
public class Detalle_Modelo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_modelo")
    private Long id_detalle_modelo;

    private double peso_total;

    @ManyToOne(fetch = FetchType.EAGER)
    private Criterio criterio ;
    @ManyToOne(fetch = FetchType.EAGER)
    private Modelo modelo ;
}
