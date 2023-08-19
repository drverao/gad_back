package com.sistema.examenes.services;

import com.sistema.examenes.entity.DetalleTrimestre;
import com.sistema.examenes.repository.DetalleTrimestreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleTrimestre_ServiceImpl extends GenericServiceImpl<DetalleTrimestre, Long> implements DetalleTrimestre_Service {

    @Autowired
    private DetalleTrimestreRepository repository;

    @Override
    public CrudRepository<DetalleTrimestre, Long> getDao() {
        return repository;
    }

    @Override
    public List<DetalleTrimestre> listar() {
        return repository.listarDetalleTrimestres();
    }
}
