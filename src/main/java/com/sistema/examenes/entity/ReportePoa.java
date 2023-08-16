package com.sistema.examenes.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "reportepoa")
public class ReportePoa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reporte")
    private Long id_reporte;
    @Column(name = "fecha")
    private Date fecha;
    @Column(name = "ejecucion_presupuesto")
    private double ejecucion_presupuesto;
    @Column(name = "visible")
    private boolean visible;

    @ManyToOne(fetch = FetchType.EAGER)
    private DetalleTrimestre detalle;
}
