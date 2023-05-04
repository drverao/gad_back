package com.sistema.examenes.services;

import com.sistema.examenes.entity.Evidencia;
import com.sistema.examenes.repository.Evidencia_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class Evidencia_ServiceImpl extends GenericServiceImpl<Evidencia, Long> implements Evidencia_Service {
    @Autowired
    private Evidencia_repository repository;
    @Override
    public CrudRepository<Evidencia, Long > getDao() {
        return repository;
    }


}
