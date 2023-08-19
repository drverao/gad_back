package com.sistema.examenes.repository;

import com.sistema.examenes.entity.Indicadores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IndicadoresRepository extends JpaRepository<Indicadores, Long> {
    @Query(value = "SELECT * from indicadores where visible =true ORDER BY nombre ASC", nativeQuery = true)
    List<Indicadores> listarIndicadoress();
}
