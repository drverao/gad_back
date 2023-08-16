package com.sistema.examenes.services;

import com.sistema.examenes.entity.ModeloPOA;

import java.util.List;

public interface ModeloPOA_Service extends GenericService<ModeloPOA, Long>{
    public List<ModeloPOA> listar();
}
