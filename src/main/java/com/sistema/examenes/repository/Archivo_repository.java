package com.sistema.examenes.repository;

import com.sistema.examenes.entity.Archivo_s;
import com.sistema.examenes.entity.Evidencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Archivo_repository extends JpaRepository<Archivo_s, Long> {
    @Query(value = "SELECT * from archivo where visible =true",nativeQuery = true)
    List<Archivo_s> listararchivo();

}
