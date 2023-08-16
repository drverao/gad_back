package com.sistema.examenes.services;

import com.sistema.examenes.entity.EjePND;
import com.sistema.examenes.entity.ModeloPOA;

import java.util.List;

public interface EjePND_Service extends GenericService<EjePND, Long>{
    public List<EjePND> listar();
}
