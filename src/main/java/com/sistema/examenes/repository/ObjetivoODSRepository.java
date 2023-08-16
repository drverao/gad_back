package com.sistema.examenes.repository;

import com.sistema.examenes.entity.ModeloPOA;
import com.sistema.examenes.entity.ObjetivoODS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ObjetivoODSRepository extends JpaRepository<ObjetivoODS, Long> {
    @Query(value = "SELECT * from objetivosods where visible =true ORDER BY nombre ASC", nativeQuery = true)
    List<ObjetivoODS> listarObjetivosODS();
}
