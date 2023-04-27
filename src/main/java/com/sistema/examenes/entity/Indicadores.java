package com.sistema.examenes.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "indicadores")
public class Indicadores implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_indicardores")
    private Long id_indicadores;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "escala")
    private String escala;
    @Column(name = "estado")
    private String estado;
}
