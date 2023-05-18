package com.sistema.examenes.repository;

import com.sistema.examenes.entity.Criterio;
import com.sistema.examenes.entity.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

public interface Modelo_repository extends JpaRepository<Modelo, Long> {
    @Query(value = "SELECT * from modelo where visible =true",nativeQuery = true)
    List<Modelo> listarModelo();
    
    @Query(value = "SELECT * FROM modelo WHERE id_modelo = (SELECT MAX(id_modelo) FROM modelo)",nativeQuery = true)
    public Modelo listarModeloMaximo();
    
    
    
    
}
