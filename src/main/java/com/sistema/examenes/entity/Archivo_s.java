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
@Table(name = "archivo")
public class Archivo_s implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_archivo")
    private Long id_evidencia;
    @Column(name = "enlace")
    private String enlace;
    @Column(name = "nombre", length = 10000)
    private String nombre;
    @Column(name = "descripcion", length = 10000)
    private String descripcion;
    @Column(name = "fecha")
    private Date fecha = new Date();
    //Columna para el eliminado logico no borrar
    @Column(name = "visible")
    private boolean visible;

    @ManyToOne(fetch = FetchType.EAGER)
    private Evidencia evidencia;

    public Archivo_s() {


    }

    public Archivo_s(String enlace, String nombre, String descripcion, boolean visible, Evidencia evidencia) {
        this.enlace = enlace;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.visible = visible;
        this.evidencia = evidencia;
    }
}

