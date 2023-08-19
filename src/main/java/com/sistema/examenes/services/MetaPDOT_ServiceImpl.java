package com.sistema.examenes.services;

import com.sistema.examenes.entity.MetaPDOT;
import com.sistema.examenes.repository.MetaPDOTRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetaPDOT_ServiceImpl extends GenericServiceImpl<MetaPDOT, Long> implements MetaPDOT_Service {

    @Autowired
    private MetaPDOTRepository repository;

    @Override
    public CrudRepository<MetaPDOT, Long> getDao() {
        return repository;
    }

    @Override
    public List<MetaPDOT> listar() {
        return repository.listarMetaPDOTs();
    }
}
