package com.sistema.examenes.fenix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.examenes.fenix.entity.Docentesfenix;

public interface DocentesfenixRepository extends JpaRepository<Docentesfenix, String> {

    // metodo para listar todos los docentes
    List<Docentesfenix> findAll();

    // metodo para buscar un docente por su id
    Docentesfenix findByCedula(String cedula);
}
