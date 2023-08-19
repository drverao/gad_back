package com.sistema.examenes.services;

import com.sistema.examenes.entity.Objetivo;

import java.util.List;

public interface Objetivo_Service extends GenericService<Objetivo, Long>{
    public List<Objetivo> listar();
}
