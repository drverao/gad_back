package com.sistema.examenes.services;

import com.sistema.examenes.entity.Actividades;
import com.sistema.examenes.repository.Actividad_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class Actividad_ServiceImpl extends GenericServiceImpl<Actividades, Long> implements Actividad_Service {
    @Autowired
    private Actividad_repository repository;
    @Override
    public CrudRepository<Actividades, Long > getDao() {
        return repository;
    }


}
