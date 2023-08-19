package com.sistema.examenes.services;

import com.sistema.examenes.entity.Objetivo;
import com.sistema.examenes.repository.ObjetivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Objetivo_ServiceImpl extends GenericServiceImpl<Objetivo, Long> implements Objetivo_Service {

    @Autowired
    private ObjetivoRepository repository;

    @Override
    public CrudRepository<Objetivo, Long> getDao() {
        return repository;
    }

    @Override
    public List<Objetivo> listar() {
        return repository.listarObjetivos();
    }
}
