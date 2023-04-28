package com.sistema.examenes.services;

import com.sistema.examenes.entity.Detalle_Modelo;
import com.sistema.examenes.repository.Detalle_Modelo_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class Detalle_Modelo_ServiceImpl extends GenericServiceImpl<Detalle_Modelo, Long> implements Detalle_Modelo_Service {
    @Autowired
    private Detalle_Modelo_repository repository;
    @Override
    public CrudRepository<Detalle_Modelo, Long > getDao() {
        return repository;
    }


}
