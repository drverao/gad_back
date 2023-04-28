package com.sistema.examenes.services;

import com.sistema.examenes.entity.Evaluar_Indicador;
import com.sistema.examenes.repository.Evaluar_Indicador_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class Evaluar_Indicador_ServiceImpl extends GenericServiceImpl<Evaluar_Indicador, Long> implements Evaluar_Indicador_Service {
    @Autowired
    private Evaluar_Indicador_repository repository;
    @Override
    public CrudRepository<Evaluar_Indicador, Long > getDao() {
        return repository;
    }


}
