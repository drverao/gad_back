package com.sistema.examenes.repository;

import com.sistema.examenes.entity.ModeloPOA;
import com.sistema.examenes.entity.ObjetivoPND;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ObjetivoPNDRepository extends JpaRepository<ObjetivoPND, Long> {
    @Query(value = "SELECT * from objetivospnd where visible =true ORDER BY nombre ASC", nativeQuery = true)
    List<ObjetivoPND> listarObjetivosPNDS();
}
