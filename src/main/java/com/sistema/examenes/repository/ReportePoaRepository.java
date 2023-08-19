package com.sistema.examenes.repository;

import com.sistema.examenes.entity.ReportePoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReportePoaRepository extends JpaRepository<ReportePoa, Long> {
    @Query(value = "SELECT * from reportepoa where visible =true ORDER BY nombre ASC", nativeQuery = true)
    List<ReportePoa> listarReportePoas();
}
