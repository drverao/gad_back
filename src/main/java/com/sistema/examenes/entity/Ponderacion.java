package com.sistema.examenes.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Getter
@Setter
@Table(name = "ponderacion")
public class Ponderacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ponderacion")
    private Long id_ponderacion;

    
    @Column(name = "peso")
    private double peso;

    @Column(name = "valor_obtenido")
    private double valor_obtenido;

    @Column(name = "porc_obtenido")
    private  double porc_obtenido;


    @Column(name = "porc_utilida_obtenida")
    private double porc_utilidad_obtenida;


    @Column(name = "fecha")
    private Date fecha;
    //Columna para el eliminado logico no borrar
    @Column(name = "visible")
    private boolean visible;
    @ManyToOne(fetch = FetchType.EAGER)
    private Modelo modelo;
    @ManyToOne(fetch = FetchType.EAGER)
    private Indicador indicador;



}
