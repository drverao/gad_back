package com.sistema.examenes.repository;

import com.sistema.examenes.entity.Indicador;
import com.sistema.examenes.entity.Subcriterio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Subcriterio_repository extends JpaRepository<Subcriterio, Long> {
    @Query(value = "SELECT * from subcriterio where visible =true",nativeQuery = true)
    List<Subcriterio> listarSubcriterio();
}
