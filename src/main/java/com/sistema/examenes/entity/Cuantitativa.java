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
@Table(name = "cuantitativa")
public class Cuantitativa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cuantitativa")
    private Long id_cuantitativa;

    private String descripcion;
    private String abreviatura;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "cuantitativa")
    @JsonIgnore
    private Set<Evaluar_Indicador> lista_eva_indicador = new HashSet<>();
}
