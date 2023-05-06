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
@Table(name = "asignacion_indicador")
public class Asignacion_Indicador implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asignacion_indicador")
    private Long id_asignacion_indicador;
    //Columna para el eliminado logico no borrar
    @Column(name = "visible")
    private boolean visible;
    @ManyToOne(fetch = FetchType.EAGER)
    private Indicador indicador;
    @ManyToOne(fetch = FetchType.EAGER)
    private Modelo modelo;

}
