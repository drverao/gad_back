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
    public CrudRepository<Indicador, Long> getDao() {

        return repository;
    }

    @Override
    public List<Indicador> listar() {
        return repository.listarIndicador();
    }

    @Override
    public List<Indicador> listarPorSubcriterio(Long id_subcriterio) {
        return repository.listarIndicadorPorSubcriterio(id_subcriterio);
    }

    @Override
    public List<Indicador> obtenerIndicadores(Long id) {
        return repository.obtenerIndicadores(id);
    }

    @Override
    public List<Indicador> listarIndicadorPorCriterioModelo(Long id_criterio, Long id_modelo) {
        return repository.listarIndicadorPorCriterioModelo(id_criterio, id_modelo);
    }
    public List<Indicador> indicadoresPorCriterios(List<Long> id_criterio) {
        return repository.indicadoresPorCriterios(id_criterio);
    }
}
