package com.sistema.examenes.repository;

import com.sistema.examenes.entity.Indicador;
import com.sistema.examenes.entity.Subcriterio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Subcriterio_repository extends JpaRepository<Subcriterio, Long> {
    @Query(value = "SELECT * from subcriterio where visible =true", nativeQuery = true)
    List<Subcriterio> listarSubcriterio();

    // un query para buscar por id_criterio
    @Query(value = "SELECT * from subcriterio where id_criterio = :id_criterio and visible =true", nativeQuery = true)
    List<Subcriterio> listarSubcriterioPorCriterio(Long id_criterio);
}
