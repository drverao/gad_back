package com.sistema.examenes.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "persona",uniqueConstraints = {@UniqueConstraint(columnNames = "cedula")})

public class Persona implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Long id_persona;
    @Column(name = "cedula")
    private String cedula;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "cargo")
    private String cargo;
    @Column(name = "estado")
    private String estado;
  //  @OneToOne(mappedBy = "persona", cascade = CascadeType.ALL)
//    private Usuario usuario;
}
