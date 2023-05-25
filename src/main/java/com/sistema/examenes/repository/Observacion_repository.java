package com.sistema.examenes.repository;

import com.sistema.examenes.entity.Criterio;
import com.sistema.examenes.entity.Observacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Observacion_repository extends JpaRepository<Observacion, Long> {

    @Query(value = "SELECT * from observacion where visible =true",nativeQuery = true)
    List<Observacion> listarObservacion();

    @Query(value = "SELECT * from observacion o JOIN usuarios u ON u.id=o.usuario_id  where o.visible =true and u.username=:user",nativeQuery = true)
    List<Observacion> observacionUsuario(String user);

    @Modifying
    @Query(value = "DELETE FROM observacion WHERE id_observacion=:id", nativeQuery = true)
    void borrar(Long id);
    
    @Query(value = "SELECT * FROM observacion WHERE actividad_id_actividad=:idact AND visible=true",nativeQuery = true)
    List<Observacion> observacionActividad(Long idact);
    
}
