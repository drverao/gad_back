package com.sistema.examenes.services;

import com.sistema.examenes.entity.Observacion;
import com.sistema.examenes.repository.Observacion_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class Observacion_ServiceImpl extends GenericServiceImpl<Observacion, Long> implements Observacion_Service {
    @Autowired
    private Observacion_repository repository;
    @Override
    public CrudRepository<Observacion, Long > getDao() {
        return repository;
    }


}