package com.sistema.examenes.repository;

import com.sistema.examenes.entity.Criterio;
import com.sistema.examenes.entity.Evaluar_Cuantitativa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Evaluar_Cuantitativa_repository extends JpaRepository<Evaluar_Cuantitativa, Long> {
    @Query(value = "SELECT * from evaluar_cuantitativa where visible =true",nativeQuery = true)
    List<Evaluar_Cuantitativa> listarEvaluarCuantitativa();
}
