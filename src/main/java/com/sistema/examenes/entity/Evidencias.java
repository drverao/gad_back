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
@Table(name = "evidencias")
public class Evidencias implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evidencia")
    private Long id_evidencia;
    @Column(name = "enlace")
    private String enlace;
    @Column(name = "nombre", length = 10000)
    private String nombre;
    @Column(name = "descripcion", length = 10000)
    private String descripcion;
    @Column(name = "fecha")
    private Date fecha;
    @Column(name = "visible")
    private Boolean visible;

    public Evidencias() {

    }
    public Evidencias(String enlace, String nombre, Date fecha, boolean visible) {
        this.enlace = enlace;
        this.nombre = nombre;
        this.fecha = fecha;
        this.visible = visible;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    private Actividades actividades;

}

