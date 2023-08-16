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
@Table(name = "metapdot")
public class MetaPDOT implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_metapdot")
    private Long id_objetivopnd;
    @Column(name = "nombre", length = 200)
    private String nombre;
    @Column(name = "descripcion", length = 1000)
    private String descripcion;
    @Column(name = "porcentaje_meta")
    private double porcentaje_meta;
    @Column(name = "visible")
    private boolean visible;



    @ManyToOne(fetch = FetchType.EAGER)
    private ObjetivoPDOT objetivopdot;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "metapdot")
    @JsonIgnore
    private Set<Indicadores> lista_indicadores = new HashSet<>();
}
