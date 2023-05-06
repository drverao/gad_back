package com.sistema.examenes.repository;

import com.sistema.examenes.entity.Criterio;
import com.sistema.examenes.entity.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Modelo_repository extends JpaRepository<Modelo, Long> {
    @Query(value = "SELECT * from modelo where visible =true",nativeQuery = true)
    List<Modelo> listarModelo();
}
