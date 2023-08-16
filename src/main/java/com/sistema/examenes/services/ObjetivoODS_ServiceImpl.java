package com.sistema.examenes.services;

import com.sistema.examenes.entity.ModeloPOA;
import com.sistema.examenes.entity.ObjetivoODS;
import com.sistema.examenes.repository.ModeloPOARepository;
import com.sistema.examenes.repository.ObjetivoODSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjetivoODS_ServiceImpl extends GenericServiceImpl<ObjetivoODS, Long> implements ObjetivoODS_Service {

    @Autowired
    private ObjetivoODSRepository repository;

    @Override
    public CrudRepository<ObjetivoODS, Long> getDao() {
        return repository;
    }

    @Override
    public List<ObjetivoODS> listar() {
        return repository.listarObjetivosODS();
    }
}
