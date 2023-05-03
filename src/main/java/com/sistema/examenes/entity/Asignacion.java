package com.sistema.examenes.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "asignacion")
public class Asignacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asignacion")
    private Long id_asignacion;

    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario usuario ;

    @ManyToOne(fetch = FetchType.EAGER)
    private Criterio criterio ;

    @ManyToOne(fetch = FetchType.EAGER)
    private Modelo modelo ;
 
    public Asignacion() {
    }

    public Asignacion(Long id_asignacion, Usuario usuario, Criterio criterio, Modelo modelo) {
        this.id_asignacion = id_asignacion;
        this.usuario = usuario;
        this.criterio = criterio;
        this.modelo = modelo;
    }
    
    
}
