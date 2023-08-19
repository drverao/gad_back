package com.sistema.examenes.repository;

import com.sistema.examenes.entity.Componente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComponenteRepository extends JpaRepository<Componente, Long> {
    @Query(value = "SELECT * from componente where visible =true ORDER BY nombre ASC", nativeQuery = true)
    List<Componente> listarComponentes();
}
