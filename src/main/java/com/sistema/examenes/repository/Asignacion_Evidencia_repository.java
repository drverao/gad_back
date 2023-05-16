package com.sistema.examenes.repository;

import com.sistema.examenes.entity.Asignacion_Evidencia;
import com.sistema.examenes.entity.Criterio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Asignacion_Evidencia_repository extends JpaRepository<Asignacion_Evidencia, Long> {
    @Query(value = "SELECT * from asignacion_evidencia where visible =true",nativeQuery = true)
    List<Asignacion_Evidencia> listarAsignacionEvidencia();
}
