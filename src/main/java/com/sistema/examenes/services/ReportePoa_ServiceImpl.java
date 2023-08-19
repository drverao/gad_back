package com.sistema.examenes.services;

import com.sistema.examenes.entity.ReportePoa;
import com.sistema.examenes.repository.ReportePoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportePoa_ServiceImpl extends GenericServiceImpl<ReportePoa, Long> implements ReportePoa_Service {

    @Autowired
    private ReportePoaRepository repository;

    @Override
    public CrudRepository<ReportePoa, Long> getDao() {
        return repository;
    }

    @Override
    public List<ReportePoa> listar() {
        return repository.listarReportePoas();
    }
}
