package com.sistema.examenes.repository;

import com.sistema.examenes.entity.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Actividad_repository extends JpaRepository<Actividad, Long> {
    List<Actividad> findByNombreContainingIgnoreCase(String nombre);

}
