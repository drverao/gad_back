package com.sistema.examenes.repository;

import com.sistema.examenes.entity.Evaluacion;
import com.sistema.examenes.entity.Evidencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Evaluacion_repository extends JpaRepository<Evaluacion, Long> {
}
