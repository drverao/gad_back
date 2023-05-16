package com.sistema.examenes.repository;

import com.sistema.examenes.entity.Asignacion_Admin;
import com.sistema.examenes.entity.Criterio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Asignacion_Admin_repository extends JpaRepository<Asignacion_Admin, Long> {
    @Query(value = "SELECT * from asignacion_admin where visible =true",nativeQuery = true)
    List<Asignacion_Admin> listarAsignacion_Admin();
}
