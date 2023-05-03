package com.sistema.examenes.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "criterio")
public class Criterio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_criterio")
    private Long id_criterio;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "peso")
    private int peso;
    @Column(name = "estado")
    private String estado;
    //Columna para el eliminado logico no borrar
    @Column(name = "visible")
    private boolean visible;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "criterio")
    @JsonIgnore
    private List<Subcriterio> lista_subcriterios = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "criterio")
    @JsonIgnore
    private Set<Asignacion> lista_det_modelo = new HashSet<>();

    public Criterio() {
    }
    
    public Criterio(Long id){
        super();
        this.id_criterio=id;
    }
}
