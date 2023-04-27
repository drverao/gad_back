package com.sistema.examenes.security;

import com.sistema.examenes.entity.Actividades;
import com.sistema.examenes.entity.Evaluacion;
import com.sistema.examenes.repository.Actividad_repository;
import com.sistema.examenes.repository.Evaluacion_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class Evaluacion_ServiceImpl extends GenericServiceImpl<Evaluacion, Long> implements Evaluacion_Service {
    @Autowired
    private Evaluacion_repository repository;
    @Override
    public CrudRepository<Evaluacion, Long > getDao() {
        return repository;
    }


}
