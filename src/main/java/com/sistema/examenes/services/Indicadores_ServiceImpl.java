package com.sistema.examenes.services;

import com.sistema.examenes.entity.Indicadores;
import com.sistema.examenes.repository.IndicadoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Indicadores_ServiceImpl extends GenericServiceImpl<Indicadores, Long> implements Indicadores_Service {

    @Autowired
    private IndicadoresRepository repository;

    @Override
    public CrudRepository<Indicadores, Long> getDao() {
        return repository;
    }

    @Override
    public List<Indicadores> listar() {
        return repository.listarIndicadoress();
    }
}
