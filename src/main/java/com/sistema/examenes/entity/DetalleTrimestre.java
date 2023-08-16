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
@Table(name = "detalletrimestre")
public class DetalleTrimestre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detatrimestre")
    private Long id_detatrimestre;
    @Column(name = "porcentaje")
    private double porcentaje;
    @Column(name = "presupuesto_referencial")
    private double presupuesto_referencial;
    @Column(name = "ejecucion_presupuesto")
    private double ejecucion_presupuesto;
    @Column(name = "visible")
    private boolean visible;

    @ManyToOne(fetch = FetchType.EAGER)
    private Actividades actividades;

    @ManyToOne(fetch = FetchType.EAGER)
    private Trimestre trimestre;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "detalle")
    @JsonIgnore
    private Set<ReportePoa> lista_reportes = new HashSet<>();
}
