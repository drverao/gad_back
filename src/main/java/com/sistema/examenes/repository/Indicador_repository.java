package com.sistema.examenes.repository;

import com.sistema.examenes.entity.Indicador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Indicador_repository extends JpaRepository<Indicador, Long> {
    @Query(value = "SELECT * from indicadores where visible =true",nativeQuery = true)
    List<Indicador> listarIndicador();
}
