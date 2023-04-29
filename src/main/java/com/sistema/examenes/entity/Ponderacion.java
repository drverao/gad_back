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
@Table(name = "ponderacion")
public class Ponderacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ponderacion")
    private Long id_ponderacion;

    private double nivel_maximo;
    private double nivel_obtenido;
    private  double nivel_obt_utilidad;
    private double poro_indicador;
    private double poro_util_obt;

    @ManyToOne(fetch = FetchType.EAGER)
    private Modelo modelo;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "ponderacion")
    @JsonIgnore
    private Set<Encabezado_Evaluar> lista_enc_eva = new HashSet<>();


    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "ponderacion")
    @JsonIgnore
    private Set<Evaluar_Cualitativa> lista_eva_cual = new HashSet<>();

}
