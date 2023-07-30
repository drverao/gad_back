package com.sistema.examenes.services;

import com.sistema.examenes.entity.Subcriterio;
import com.sistema.examenes.repository.Subcriterio_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class Subcriterio_ServiceImpl extends GenericServiceImpl<Subcriterio, Long> implements Subcriterio_Service {
    @Autowired
    private Subcriterio_repository repository;

    @Override
    public CrudRepository<Subcriterio, Long> getDao() {

        return repository;
    }

    @Override
    public List<Subcriterio> listar() {
        return repository.listarSubcriterio();
    }

    @Override
    public List<Subcriterio> listarPorCriterio(Long id_criterio) {
        return repository.listarSubcriterioPorCriterio(id_criterio);
    }

    @Override
    public List<Map<String, Object>> listarSubcriterioPorCriterioConDatosEspecificos(Long id_criterio) {
        return repository.listarSubcriterioPorCriterioConDatosEspecificos(id_criterio);
    }
}
