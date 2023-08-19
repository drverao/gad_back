package com.sistema.examenes.services;

import com.sistema.examenes.entity.Trimestre;
import com.sistema.examenes.repository.TrimestreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Trimestre_ServiceImpl extends GenericServiceImpl<Trimestre, Long> implements Trimestre_Service {

    @Autowired
    private TrimestreRepository repository;

    @Override
    public CrudRepository<Trimestre, Long> getDao() {
        return repository;
    }

    @Override
    public List<Trimestre> listar() {
        return repository.listarTrimestres();
    }
}
