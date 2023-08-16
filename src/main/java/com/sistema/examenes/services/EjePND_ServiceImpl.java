package com.sistema.examenes.services;

import com.sistema.examenes.entity.EjePND;
import com.sistema.examenes.entity.ModeloPOA;
import com.sistema.examenes.repository.EjePNDRepository;
import com.sistema.examenes.repository.ModeloPOARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EjePND_ServiceImpl extends GenericServiceImpl<EjePND, Long> implements EjePND_Service {

    @Autowired
    private EjePNDRepository repository;

    @Override
    public CrudRepository<EjePND, Long> getDao() {
        return repository;
    }

    @Override
    public List<EjePND> listar() {
        return repository.listarEje();
    }
}
