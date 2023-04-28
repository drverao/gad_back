package com.sistema.examenes.services;

import com.sistema.examenes.entity.Detalle_Evidencia;
import com.sistema.examenes.repository.Detalle_Evidencia_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class Detalle_Evidencia_ServiceImpl extends GenericServiceImpl<Detalle_Evidencia, Long> implements Detalle_Evidencia_Service {
    @Autowired
    private Detalle_Evidencia_repository repository;
    @Override
    public CrudRepository<Detalle_Evidencia, Long > getDao() {
        return repository;
    }


}
