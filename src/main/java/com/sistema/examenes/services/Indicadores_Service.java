package com.sistema.examenes.services;

import com.sistema.examenes.entity.Indicadores;

import java.util.List;

public interface Indicadores_Service extends GenericService<Indicadores, Long>{
    public List<Indicadores> listar();
}
