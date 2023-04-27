package com.sistema.examenes.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "evidencia")
public class Evidencia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evidencia")
    private Long id_evidencia;
    @Column(name = "enlace")
    private String enlace;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "estado")
    private String estado;
}
