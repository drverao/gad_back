package com.sistema.examenes.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "asignacion_criterio")
public class Asignacion_Criterio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asignacio_criterio")
    private Long id_asignacio_criterio;
    //Columna para el eliminado logico no borrar
    @Column(name = "visible")
    private boolean visible;
    @ManyToOne(fetch = FetchType.EAGER)
    private Criterio criterio;
    @ManyToOne(fetch = FetchType.EAGER)
    private Modelo modelo;
}
