package com.sistema.examenes.repository;

import com.sistema.examenes.entity.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
    @Query(value = "SELECT * from proyecto where visible =true ORDER BY nombre ASC", nativeQuery = true)
    List<Proyecto> listarProyectos();
}
