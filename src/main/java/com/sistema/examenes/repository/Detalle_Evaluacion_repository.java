package com.sistema.examenes.repository;

import com.sistema.examenes.entity.Criterio;
import com.sistema.examenes.entity.Detalle_Evaluacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Detalle_Evaluacion_repository extends JpaRepository<Detalle_Evaluacion, Long> {
    @Query(value = "SELECT * from detalle_evaluacion where visible =true",nativeQuery = true)
    List<Detalle_Evaluacion> listarDetalleEvaluacion();

    @Query(value = "    SELECT * FROM detalle_evaluacion\n" +
            "    WHERE visible = true AND evidencia_id_evidencia = :idEvidencia AND estado = false AND usuario_id = :idUsuario",nativeQuery = true)
    List<Detalle_Evaluacion> listarDetalleEvaluacionRechazada(  Long idEvidencia, Long idUsuario);
    @Query(value = "    SELECT * FROM detalle_evaluacion\n" +
            "    WHERE visible = true AND evidencia_id_evidencia = :idEvidencia AND estado = true AND usuario_id = :idUsuario",nativeQuery = true)
    List<Detalle_Evaluacion> listarDetalleEvaluacionAprobada(  Long idEvidencia, Long idUsuario);


}
