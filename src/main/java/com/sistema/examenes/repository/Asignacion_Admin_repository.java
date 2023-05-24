package com.sistema.examenes.repository;

import com.sistema.examenes.entity.Asignacion_Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Asignacion_Admin_repository extends JpaRepository<Asignacion_Admin, Long> {
    @Query(value = "SELECT * from asignacion_admin where visible =true", nativeQuery = true)
    List<Asignacion_Admin> listarAsignacion_Admin();

    @Query(value = "SELECT * from asignacion_admin where criterio_id_criterio = :id_usuario and visible =true", nativeQuery = true)
    Asignacion_Admin listarAsignacion_AdminPorUsuario(Long id_usuario);

    @Query(value = "SELECT * from asignacion_admin where criterio_id_criterio = :id_criterio and usuario_id = :id_usuario", nativeQuery = true)
    Asignacion_Admin listarAsignacion_AdminPorUsuarioCriterio(Long id_criterio, Long id_usuario);
}
