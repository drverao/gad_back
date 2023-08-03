package com.sistema.examenes.services;

import com.sistema.examenes.entity.Criterio;
import com.sistema.examenes.repository.Criterio_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Criterio_ServiceImpl extends GenericServiceImpl<Criterio, Long> implements Criterio_Service {

    @Autowired
    private Criterio_repository repository;

    @Override
    public CrudRepository<Criterio, Long> getDao() {

        return repository;
    }

    @Override
    public List<Criterio> listar() {
        return repository.listarCriterio();
    }

    @Override
    public List<Criterio> obtenerCriterios() {
        return repository.obtenerCriterios();
    }

    @Override
    public List<Criterio> obtenerCriteriosUltimoModelo() {
        return repository.obtenerCriteriosUltimoModelo();
    }

    @Override
    public List<Criterio> obtenerCriterioModelo() {
        return repository.obtenerCriteriosModelo();
    }

    public List<Criterio> obtenerCriterioIdModelo(Long id) {
        return repository.obtenerCriteriosModeloId(id);
    }

    public List<Criterio> obtenerCriterioPertenecientesAModelo(Long id) {
        return repository.obtenerCriteriosPertenecientesAModelo(id);
    }
    @Override
    public List<Criterio> listarCriterioPorIndicador(Long id_indicador) {
        return repository.listarCriterioPorIndicador(id_indicador);
    }

}
