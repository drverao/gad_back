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
@Table(name = "indicadores")
public class Indicador implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_indicardores")
    private Long id_indicadores;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "peso")
    private double peso;
    @Column(name = "tipo")
    private String tipo;
    //
    @Column(name = "visible")
    private boolean visible;
    //
    @ManyToOne(fetch = FetchType.EAGER)
    private Subcriterio subcriterio;


    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "indicador")
    @JsonIgnore
    private Set<Evaluar_Cualitativa> lista_eva_cual = new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "indicador")
    @JsonIgnore
    private Set<Detalle_Evidencia> lista_det_evi = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "indicador")
    @JsonIgnore
    private Set<Encabezado_Evaluar> lista_enc_eva = new HashSet<>();



}
