package com.sistema.examenes.services;

import com.sistema.examenes.entity.ReportePoa;

import java.util.List;

public interface ReportePoa_Service extends GenericService<ReportePoa, Long>{
    public List<ReportePoa> listar();
}
