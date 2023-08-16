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
@Table(name = "objetivospnd")
public class ObjetivoPND implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_objetivopnd")
    private Long id_objetivopnd;
    @Column(name = "nombre", length = 200)
    private String nombre;
    @Column(name = "descripcion", length = 1000)
    private String descripcion;
    @Column(name = "visible")
    private boolean visible;

    //Relacion con eje
    @ManyToOne(fetch = FetchType.EAGER)
    private EjePND eje;

    //Relacion a proyecto
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "pnd")
    @JsonIgnore
    private Set<Proyecto> lista_proyectos = new HashSet<>();
}
