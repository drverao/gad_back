package com.sistema.examenes.services;

import com.sistema.examenes.entity.Evidencias;
import com.sistema.examenes.repository.EvidenciasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Evidencias_ServiceImpl extends GenericServiceImpl<Evidencias, Long> implements Evidencias_Service {

    @Autowired
    private EvidenciasRepository repository;

    @Override
    public CrudRepository<Evidencias, Long> getDao() {
        return repository;
    }

    @Override
    public List<Evidencias> listar() {
        return repository.listarEvidenciass();
    }
}
