package com.sistema.examenes.services;

import com.sistema.examenes.entity.Asignacion_Criterio;
import com.sistema.examenes.repository.Asignacion_Criterio_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class Asignacion_Criterio_ServiceImpl extends GenericServiceImpl<Asignacion_Criterio, Long> implements Asignacion_Criterio_Service {
    @Autowired
    private Asignacion_Criterio_repository repository;
    @Override
    public CrudRepository<Asignacion_Criterio, Long > getDao() {
        return repository;
    }
}
