package com.sistema.examenes.services;

import com.sistema.examenes.entity.Actividad;
import com.sistema.examenes.repository.Actividad_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Actividad_ServiceImpl extends GenericServiceImpl<Actividad, Long> implements Actividad_Service {
    @Autowired
    private Actividad_repository repository;
    @Override
    public CrudRepository<Actividad, Long > getDao() {
        return repository;
    }
    @Override
    public List<Actividad> findByNombreContainingIgnoreCase(String nombre) {
        return repository.findByNombreContainingIgnoreCase(nombre);
    }


}
