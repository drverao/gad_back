package com.sistema.examenes.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "evaluacion")
public class Evaluacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evaluacion")
    private Long id_evaluacion;
    @Column(name = "obcervaciones")
    private String obcervaciones;
    @Column(name = "fecha_evaluacion")
    private String fecha_evaluacionString;
    @Column(name = "estado")
    private String estado;
}
