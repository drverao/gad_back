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

    @Column(name = "descripcion", length = 10000)
    private String descripcion;
    //Columna para el eliminado logico no borrar
    @Column(name = "visible")
    private Boolean visible;

    @ManyToOne(fetch = FetchType.EAGER)
    private Indicador indicador;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "evidencia")
    @JsonIgnore
    private Set<Detalle_Evaluacion> detalleEvaluaciones = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "evidencia")
    @JsonIgnore
    private Set<Actividad> listaactividades = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "evidencia")
    @JsonIgnore
    private Set<Asignacion_Evidencia> lista_evidencias = new HashSet<>();


    public Evidencia() {

    }
}

