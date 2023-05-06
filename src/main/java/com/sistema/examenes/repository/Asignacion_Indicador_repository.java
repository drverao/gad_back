package com.sistema.examenes.repository;

import com.sistema.examenes.entity.Asignacion_Indicador;
import com.sistema.examenes.entity.Criterio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Asignacion_Indicador_repository extends JpaRepository<Asignacion_Indicador, Long> {
    @Query(value = "SELECT * from asignacion_indicador where visible =true",nativeQuery = true)
    List<Asignacion_Indicador> listarAsignacionIndicador();
}
