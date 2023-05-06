package com.sistema.examenes.repository;

import com.sistema.examenes.entity.Criterio;
import com.sistema.examenes.entity.Observacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Observacion_repository extends JpaRepository<Observacion, Long> {

    @Query(value = "SELECT * from observacion where visible =true",nativeQuery = true)
    List<Observacion> listarObservacion();
}
