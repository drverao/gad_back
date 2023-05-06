package com.sistema.examenes.repository;

import com.sistema.examenes.entity.Criterio;
import com.sistema.examenes.entity.Ponderacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Ponderacion_repository extends JpaRepository<Ponderacion, Long> {
    @Query(value = "SELECT * from ponderacion where visible =true",nativeQuery = true)
    List<Ponderacion> listarPonderacion();
}
