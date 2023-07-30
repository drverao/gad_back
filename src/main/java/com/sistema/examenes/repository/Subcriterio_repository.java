package com.sistema.examenes.repository;

import com.sistema.examenes.entity.Indicador;
import com.sistema.examenes.entity.Subcriterio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface Subcriterio_repository extends JpaRepository<Subcriterio, Long> {
    @Query(value = "SELECT * from subcriterio where visible =true", nativeQuery = true)
    List<Subcriterio> listarSubcriterio();

    // un query para buscar por id_criterio
    @Query(value = "SELECT * from subcriterio where id_criterio = :id_criterio and visible =true", nativeQuery = true)
    List<Subcriterio> listarSubcriterioPorCriterio(Long id_criterio);

    //Listar subcriterio por un criterio trayendo datos especificos
    //Se hace Map ya q accedemos a datos de dos entidades distintas
    @Query(value = "SELECT sc.id_subcriterio as id_subcriterio, sc.descripcion as descripcion, " +
            "sc.nombre as nombreSubcriterio, c.nombre as nombreCriterio " +
            "FROM subcriterio sc " +
            "JOIN criterio c ON sc.id_criterio = c.id_criterio " +
            "WHERE sc.id_criterio = :id_criterio AND sc.visible = true", nativeQuery = true)
    List<Map<String, Object>> listarSubcriterioPorCriterioConDatosEspecificos(Long id_criterio);

}
