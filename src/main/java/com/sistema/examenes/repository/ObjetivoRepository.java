package com.sistema.examenes.repository;

import com.sistema.examenes.entity.Objetivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ObjetivoRepository extends JpaRepository<Objetivo, Long> {
    @Query(value = "SELECT * from objetivo where visible =true ORDER BY nombre ASC", nativeQuery = true)
    List<Objetivo> listarObjetivos();
}
