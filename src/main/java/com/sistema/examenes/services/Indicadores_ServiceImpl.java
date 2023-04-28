package com.sistema.examenes.services;

import com.sistema.examenes.entity.Indicadores;
import com.sistema.examenes.repository.Indicadores_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class Indicadores_ServiceImpl extends GenericServiceImpl<Indicadores, Long> implements Indicadores_Service {
    @Autowired
    private Indicadores_repository repository;
    @Override
    public CrudRepository<Indicadores, Long > getDao() {

        return repository;
    }


}
