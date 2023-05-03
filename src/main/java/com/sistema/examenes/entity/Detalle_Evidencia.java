package com.sistema.examenes.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "detalle_evidencia")
public class Detalle_Evidencia  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_evidencia")
    private Long id_detalle_evidencia;
    @Column(name = "fecha_evidencia")
    private Long fecha_evidencia;


    @ManyToOne(fetch = FetchType.EAGER)
    private Evidencia evidencia;
    @ManyToOne(fetch = FetchType.EAGER)
    private Indicador indicador;
}
