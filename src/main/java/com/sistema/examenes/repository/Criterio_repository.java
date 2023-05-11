package com.sistema.examenes.repository;

import com.sistema.examenes.entity.Criterio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Criterio_repository extends JpaRepository<Criterio, Long> {
    @Query(value = "SELECT * from criterio where visible =true", nativeQuery = true)
    List<Criterio> listarCriterio();

    @Query(value = "SELECT c.id_criterio, c.nombre, c.descripcion, c.visible FROM indicador i JOIN subcriterio s " +
            "ON s.id_subcriterio = i.subcriterio_id_subcriterio JOIN criterio c " +
            "ON c.id_criterio = s.id_criterio where c.visible =true GROUP BY c.id_criterio, c.nombre ORDER BY c.id_criterio;", nativeQuery = true)
    public List<Criterio> obtenerCriterios();

}
