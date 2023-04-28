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
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "escala")
    private String escala;
    @Column(name = "estado")
    private String estado;

    @ManyToOne(fetch = FetchType.EAGER)
    private Subcriterio subcriterio;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "indicador")
    @JsonIgnore
    private Set<Detalle_Evidencia> lista_det_evidencias = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "indicador")
    @JsonIgnore
    private Set<Cualitativa> lista_cualitativas = new HashSet<>();


}
