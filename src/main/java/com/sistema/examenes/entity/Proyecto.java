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
@Table(name = "proyecto")
public class Proyecto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proyecto")
    private Long id_proyecto;
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "nombre", length = 200)
    private String nombre;
    @Column(name = "objetivo", length = 2000)
    private String objetivo;
    @Column(name = "meta", length = 2000)
    private String meta;
    @Column(name = "porcentaje_alcance")
    private double porcentaje_alcance;
    @Column(name = "visible")
    private boolean visible;

    @ManyToOne(fetch = FetchType.EAGER)
    private ObjetivoPND pnd;
    @ManyToOne(fetch = FetchType.EAGER)
    private ObjetivoODS ods;
    @ManyToOne(fetch = FetchType.EAGER)
    private ModeloPOA modelopoa;
    @ManyToOne(fetch = FetchType.EAGER)
    private Programa programa;
    @ManyToOne(fetch = FetchType.EAGER)
    private Indicadores indicadores;
    @ManyToOne(fetch = FetchType.EAGER)
    private Componente componente;
    @ManyToOne(fetch = FetchType.EAGER)
    private Competencia competencia;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "proyecto")
    @JsonIgnore
    private Set<Poa> lista_poas = new HashSet<>();
}
