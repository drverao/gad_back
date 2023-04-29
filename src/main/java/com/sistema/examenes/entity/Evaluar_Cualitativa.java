package com.sistema.examenes.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "evaluar_cualitativa")
public class Evaluar_Cualitativa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evaluar_cualitativa")
    private Long id_evaluar_cualitativa;


    @ManyToOne(fetch = FetchType.EAGER)
    private Cualitativa cualitativa ;
    @ManyToOne(fetch = FetchType.EAGER)
    private Ponderacion ponderacion ;
    @ManyToOne(fetch = FetchType.EAGER)
    private Indicador indicador ;
}
