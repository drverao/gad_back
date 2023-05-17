package com.sistema.examenes.repository;

import com.sistema.examenes.entity.Criterio;
import com.sistema.examenes.entity.Evidencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Evidencia_repository extends JpaRepository<Evidencia, Long> {
    @Query(value = "SELECT * from evidencia where visible =true", nativeQuery = true)
    List<Evidencia> listarEvidencia();

    @Query(value = "SELECT * from evidencia e JOIN asignacion_evidencia ae ON ae.evidencia_id_evidencia = e.id_evidencia\n"
            +
            "JOIN usuarios u ON ae.usuario_id = u.id where u.username=:username and e.visible =true", nativeQuery = true)
    public List<Evidencia> evidenciaUsuario(String username);

    // SELECT evidencia.*
    // FROM public.indicador join public.evidencia ON
    // evidencia.indicador_id_indicador = indicador.id_indicador
    // WHERE evidencia.indicador_id_indicador=6 And evidencia.visible=true;
    @Query(value = "SELECT evidencia.* FROM public.indicador join public.evidencia ON evidencia.indicador_id_indicador = indicador.id_indicador WHERE evidencia.indicador_id_indicador=:id_indicador And evidencia.visible=true", nativeQuery = true)
    List<Evidencia> listarEvidenciaPorIndicador(Long id_indicador);
}
