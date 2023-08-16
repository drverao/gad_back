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
@Table(name = "componente")
public class Componente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_componente")
    private Long id_componente;
    @Column(name = "nombre", length = 200)
    private String nombre;
    @Column(name = "codigo", length = 100)
    private String codigo;
    @Column(name = "visible")
    private boolean visible;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "componente")
    @JsonIgnore
    private Set<Objetivo> lista_objetivos = new HashSet<>();
}
