package com.sistema.examenes.services;

import com.sistema.examenes.entity.Actividad;
import com.sistema.examenes.entity.Ponderacion;
import com.sistema.examenes.repository.Ponderacion_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Ponderacion_ServiceImpl extends GenericServiceImpl<Ponderacion, Long> implements Ponderacion_Service {
    @Autowired
    private Ponderacion_repository repository;
    @Override
    public CrudRepository<Ponderacion, Long > getDao() {
        return repository;
    }

    @Override
    public List<Ponderacion> listar() {
        return repository.listarPonderacion();
    }
}
