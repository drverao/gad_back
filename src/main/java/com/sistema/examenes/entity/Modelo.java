package com.sistema.examenes.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "modelo")
public class Modelo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_modelo")
    private Long id_modelo;

    private Date fecha_inicio;
    private Date fecha_fin;
    private Date fecha_final_act;

    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario usuario;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "modelo")
    @JsonIgnore
    private Set<Asignacion> lista_det_modelo = new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "modelo")
    @JsonIgnore
    private Set<Ponderacion> ponderacion = new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "modelo")
    @JsonIgnore
    private Set<Reporte> list_reporte = new HashSet<>();
    
    public Modelo(Long id){
        super();
        this.id_modelo=id;
    }

    public Modelo() {
    }
    
    
}
