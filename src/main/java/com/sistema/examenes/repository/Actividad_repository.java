package com.sistema.examenes.repository;

import com.sistema.examenes.entity.Actividad;
import com.sistema.examenes.entity.Criterio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Actividad_repository extends JpaRepository<Actividad, Long> {
    @Query(value = "SELECT * from actividad where visible =true",nativeQuery = true)
    List<Actividad> listarActividad();
    @Query(value = "SELECT * FROM actividad WHERE usuario_id= :usuario",nativeQuery = true)
    List<Actividad>listarporusuario(Long usuario);
}
