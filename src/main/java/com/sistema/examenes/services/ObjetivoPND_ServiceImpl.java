package com.sistema.examenes.services;

import com.sistema.examenes.entity.ModeloPOA;
import com.sistema.examenes.entity.ObjetivoPND;
import com.sistema.examenes.repository.ModeloPOARepository;
import com.sistema.examenes.repository.ObjetivoPNDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjetivoPND_ServiceImpl extends GenericServiceImpl<ObjetivoPND, Long> implements ObjetivoPND_Service {

    @Autowired
    private ObjetivoPNDRepository repository;

    @Override
    public CrudRepository<ObjetivoPND, Long> getDao() {
        return repository;
    }

    @Override
    public List<ObjetivoPND> listar() {
        return repository.listarObjetivosPNDS();
    }
}
