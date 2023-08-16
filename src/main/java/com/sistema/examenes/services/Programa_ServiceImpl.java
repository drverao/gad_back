package com.sistema.examenes.services;

import com.sistema.examenes.entity.EjePND;
import com.sistema.examenes.entity.Programa;
import com.sistema.examenes.repository.EjePNDRepository;
import com.sistema.examenes.repository.ProgramaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Programa_ServiceImpl extends GenericServiceImpl<Programa, Long> implements Programa_Service {

    @Autowired
    private ProgramaRepository repository;

    @Override
    public CrudRepository<Programa, Long> getDao() {
        return repository;
    }

    @Override
    public List<Programa> listar() {
        return repository.listarProgramas();
    }
}
