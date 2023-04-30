package com.sistema.examenes.services;

import com.sistema.examenes.entity.Asignacion;
import com.sistema.examenes.repository.Asignacion_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class Asignacion_ServiceImpl extends GenericServiceImpl<Asignacion, Long> implements Asignacion_Service {
    @Autowired
    private Asignacion_repository repository;
    @Override
    public CrudRepository<Asignacion, Long > getDao() {
        return repository;
    }


}
