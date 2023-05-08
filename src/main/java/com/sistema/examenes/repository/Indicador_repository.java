package com.sistema.examenes.repository;

import com.sistema.examenes.entity.Indicador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Indicador_repository extends JpaRepository<Indicador, Long> {
    @Query(value = "SELECT * from indicador where visible =true",nativeQuery = true)
    List<Indicador> listarIndicador();

    @Query(value = "SELECT *  FROM indicador i JOIN subcriterio s ON s.id_subcriterio = i.subcriterio_id_subcriterio JOIN criterio c ON c.id_criterio = s.id_criterio " +
            "WHERE c.id_criterio = :criterio GROUP BY i.id_indicador,s.id_subcriterio, c.id_criterio, c.nombre ORDER BY i.id_indicador",nativeQuery = true)
    public List<Indicador> obtenerIndicadores(Long criterio);
}
