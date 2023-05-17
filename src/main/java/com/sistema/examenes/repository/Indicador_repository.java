package com.sistema.examenes.repository;

import com.sistema.examenes.entity.Indicador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Indicador_repository extends JpaRepository<Indicador, Long> {

    // un query para buscar por id_subcriterio
    @Query(value = "SELECT * from indicador where subcriterio_id_subcriterio = :id_subcriterio", nativeQuery = true)
    List<Indicador> listarIndicadorPorSubcriterio(Long id_subcriterio);

    @Query(value = "SELECT * from indicador where visible =true", nativeQuery = true)
    List<Indicador> listarIndicador();

    @Query(value = "SELECT *  FROM indicador i JOIN subcriterio s ON s.id_subcriterio = i.subcriterio_id_subcriterio JOIN criterio c ON c.id_criterio = s.id_criterio "
            +
            "WHERE c.id_criterio = :criterio GROUP BY i.id_indicador,s.id_subcriterio, c.id_criterio, c.nombre ORDER BY i.id_indicador", nativeQuery = true)
    public List<Indicador> obtenerIndicadores(Long criterio);

    // SELECT
    // i.*
    // FROM public.modelo m join public.asignacion_indicador a ON a.modelo_id_modelo
    // = m.id_modelo
    // JOIN public.indicador i on a.indicador_id_indicador = i.id_indicador
    // JOIN public.subcriterio s ON s.id_subcriterio = i.subcriterio_id_subcriterio
    // JOIN public.criterio c ON c.id_criterio = s.id_criterio
    // WHERE c.id_criterio=1 and m.id_modelo=1
    // ORDER BY i.nombre

    @Query(value = "SELECT i.* FROM public.modelo m join public.asignacion_indicador a ON a.modelo_id_modelo = m.id_modelo JOIN public.indicador i on a.indicador_id_indicador = i.id_indicador JOIN public.subcriterio s ON s.id_subcriterio = i.subcriterio_id_subcriterio JOIN public.criterio c ON c.id_criterio = s.id_criterio WHERE c.id_criterio= :id_criterio and m.id_modelo= :id_modelo ORDER BY i.nombre", nativeQuery = true)
    List<Indicador> listarIndicadorPorCriterioModelo(Long id_criterio, Long id_modelo);


}
