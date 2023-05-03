package com.sistema.examenes.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToOne(fetch = FetchType.EAGER)
    private Actividad actividad;


    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "evidencia")
    @JsonIgnore
    private Set<Detalle_Evaluacion> detalleEvaluaciones = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "evidencia")
    @JsonIgnore
    private Set<Detalle_Evidencia> detalleEvidencias = new HashSet<>();
}

