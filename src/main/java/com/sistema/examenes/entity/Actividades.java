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
@Table(name = "actividades")
public class Actividades implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_actividad")
    private Long id_actividad;
    @Column(name = "nombre", length = 200)
    private String nombre;
    @Column(name = "observaciones", length = 2000)
    private String observaciones;
    @Column(name = "presupuesto_referencial")
    private double presupuesto_referencial;
    @Column(name = "visible")
    private boolean visible;

    @ManyToOne(fetch = FetchType.EAGER)
    private Poa poa;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "actividades")
    @JsonIgnore
    private Set<Evidencias> lista_evidencias = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "actividades")
    @JsonIgnore
    private Set<DetalleTrimestre> lista_detatrimestres = new HashSet<>();

}
