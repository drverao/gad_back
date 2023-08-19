package com.sistema.examenes.services;

import com.sistema.examenes.entity.Actividades;
import com.sistema.examenes.repository.ActividadesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Actividades_ServiceImpl extends GenericServiceImpl<Actividades, Long> implements Actividades_Service {

    @Autowired
    private ActividadesRepository repository;

    @Override
    public CrudRepository<Actividades, Long> getDao() {
        return repository;
    }

    @Override
    public List<Actividades> listar() {
        return repository.listarActividadess();
    }
}
