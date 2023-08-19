package com.sistema.examenes.services;

import com.sistema.examenes.entity.Componente;
import com.sistema.examenes.repository.ComponenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Componente_ServiceImpl extends GenericServiceImpl<Componente, Long> implements Componente_Service {

    @Autowired
    private ComponenteRepository repository;

    @Override
    public CrudRepository<Componente, Long> getDao() {
        return repository;
    }

    @Override
    public List<Componente> listar() {
        return repository.listarComponentes();
    }
}
