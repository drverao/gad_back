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

    @Column(name = "nivel_maximo")
    private double nivel_maximo;

    @Column(name = "nivel_obtenido")
    private double nivel_obtenido;

    @Column(name = "nivel_obt_utilidad")
    private  double nivel_obt_utilidad;

    @Column(name = "porc_indicador")
   private double porc_indicador;

    @Column(name = "porc_util_obt")
    private double porc_util_obt;

    @Column(name = "poso_criterio")
    private double poso_indicador;

    @Column(name = "poso_crit_obt")
    private double poso_crit_obt;

    @ManyToOne(fetch = FetchType.EAGER)
    private Modelo modelo;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "ponderacion")
    @JsonIgnore
    private Set<Encabezado_Evaluar> lista_enc_eva = new HashSet<>();


    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "ponderacion")
        @JsonIgnore
    private Set<Evaluar_Cualitativa> lista_eva_cual = new HashSet<>();
}
