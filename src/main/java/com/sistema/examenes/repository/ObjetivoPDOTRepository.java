package com.sistema.examenes.repository;

import com.sistema.examenes.entity.EjePND;
import com.sistema.examenes.entity.ObjetivoPDOT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ObjetivoPDOTRepository extends JpaRepository<ObjetivoPDOT, Long> {
    @Query(value = "SELECT * from objetivospdot where visible =true ORDER BY nombre ASC", nativeQuery = true)
    List<ObjetivoPDOT> listarObjetivosPdots();
}
