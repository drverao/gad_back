package com.sistema.examenes.services;

import com.sistema.examenes.entity.ModeloPOA;
import com.sistema.examenes.entity.ObjetivoODS;

import java.util.List;

public interface ObjetivoODS_Service extends GenericService<ObjetivoODS, Long>{
    public List<ObjetivoODS> listar();
}
