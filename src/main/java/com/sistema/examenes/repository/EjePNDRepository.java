package com.sistema.examenes.repository;

import com.sistema.examenes.entity.EjePND;
import com.sistema.examenes.entity.ModeloPOA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EjePNDRepository extends JpaRepository<EjePND, Long> {
    @Query(value = "SELECT * from ejepnd where visible =true ORDER BY nombre ASC", nativeQuery = true)
    List<EjePND> listarEje();
}
