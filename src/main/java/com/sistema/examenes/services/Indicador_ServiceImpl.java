package com.sistema.examenes.services;

import com.sistema.examenes.entity.Indicador;
import com.sistema.examenes.repository.Indicador_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Indicador_ServiceImpl extends GenericServiceImpl<Indicador, Long> implements Indicador_Service {
    @Autowired
    private Indicador_repository repository;
    @Override
    public CrudRepository<Indicador, Long > getDao() {

        return repository;
    }

    @Override
    public List<Indicador> listar() {
        return repository.listarIndicador();
    }

    @Override
    public List<Indicador> obtenerIndicadores(Long id) {
        return repository.obtenerIndicadores(id);
    }
}
