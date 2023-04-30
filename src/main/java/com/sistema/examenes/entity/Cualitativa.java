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
@Table(name = "cualitativa")
public class Cualitativa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cualitativa")
    private Long id_cualitativa;
    private double valor;
    private String escala;

    @ManyToOne(fetch = FetchType.EAGER)
    private Indicador indicador;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "cualitativa")
    @JsonIgnore
    private Set<Evaluar_Cualitativa> lista_eva_cual = new HashSet<>();
}
