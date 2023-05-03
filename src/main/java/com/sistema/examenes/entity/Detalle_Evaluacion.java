package com.sistema.examenes.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "detalle_evaluacion")
public class Detalle_Evaluacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_evaluacion")
    private Long id_detalle_evaluacion;
    @Column(name = "estado")
    private boolean estado;
    @Column(name = "observacion")
    private String observacion;

    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario usuario;
    @ManyToOne(fetch = FetchType.EAGER)
    private Evidencia evidencia;

}
