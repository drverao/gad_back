package com.sistema.examenes.services;

import com.sistema.examenes.entity.Subcriterio;

import java.util.List;
import java.util.Map;

public interface Subcriterio_Service extends GenericService<Subcriterio, Long> {

    public List<Subcriterio> listar();

    public List<Subcriterio> listarPorCriterio(Long id_criterio);

    //Subcriterios por Criterio con datos especificos
    public List<Map<String, Object>> listarSubcriterioPorCriterioConDatosEspecificos(Long id_criterio);
}
