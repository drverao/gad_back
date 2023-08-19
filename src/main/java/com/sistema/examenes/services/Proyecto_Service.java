package com.sistema.examenes.services;

import com.sistema.examenes.entity.Proyecto;

import java.util.List;

public interface Proyecto_Service extends GenericService<Proyecto, Long>{
    public List<Proyecto> listar();
}
