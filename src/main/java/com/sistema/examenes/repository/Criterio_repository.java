package com.sistema.examenes.repository;

import com.sistema.examenes.entity.Criterio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Criterio_repository extends JpaRepository<Criterio, Long> {
    @Query(value = "SELECT * from criterio where visible =true",nativeQuery = true)
    List<Criterio> listarCriterio();
}
