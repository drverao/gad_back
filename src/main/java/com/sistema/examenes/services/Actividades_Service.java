package com.sistema.examenes.services;

import com.sistema.examenes.entity.Actividades;

import java.util.List;

public interface Actividades_Service extends GenericService<Actividades, Long>{
    public List<Actividades> listar();
}
