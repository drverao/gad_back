package com.sistema.examenes.repository;

import com.sistema.examenes.entity.Asignacion_Indicador;
import com.sistema.examenes.entity.Criterio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Asignacion_Indicador_repository extends JpaRepository<Asignacion_Indicador, Long> {

    @Query(value = "SELECT * from asignacion_indicador where visible =true", nativeQuery = true)
    List<Asignacion_Indicador> listarAsignacionIndicador();

    @Query(value = "SELECT m.id_modelo AS modelo_id, i.nombre AS indicador\n" +
            "                 FROM modelo m\n" +
            "                 JOIN asignacion_indicador ai ON m.id_modelo = ai.modelo_id_modelo\n" +
            "                 JOIN indicador i ON ai.indicador_id_indicador = i.id_indicador", nativeQuery = true)
    public abstract List<Asignacion_Indicador> listaIndicador();

}
