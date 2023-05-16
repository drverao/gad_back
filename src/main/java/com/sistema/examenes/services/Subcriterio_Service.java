package com.sistema.examenes.services;

import com.sistema.examenes.entity.Subcriterio;

import java.util.List;

public interface Subcriterio_Service extends GenericService<Subcriterio, Long> {

    public List<Subcriterio> listar();

    public List<Subcriterio> listarPorCriterio(Long id_criterio);
}
