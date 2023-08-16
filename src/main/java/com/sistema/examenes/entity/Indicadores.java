package com.sistema.examenes.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "indicadores")
public class Indicadores implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_indicadores")
    private Long id_indicadores;
    @Column(name = "presupuesto_referencial")
    private double presupuesto_referencial;
    @Column(name = "fecha_cumplimiento")
    private Date fecha_cumplimiento;
    @Column(name = "tipo_evaluacion", length = 1000)
    private String tipo_evaluacion;
    @Column(name = "visible")
    private boolean visible;


    //Relacion a proyecto
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "indicadores")
    @JsonIgnore
    private Set<Proyecto> lista_proyectos = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    private MetaPDOT metapdot;
}
