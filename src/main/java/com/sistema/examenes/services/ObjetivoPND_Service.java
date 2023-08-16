package com.sistema.examenes.services;

import com.sistema.examenes.entity.ModeloPOA;
import com.sistema.examenes.entity.ObjetivoPND;

import java.util.List;

public interface ObjetivoPND_Service extends GenericService<ObjetivoPND, Long>{
    public List<ObjetivoPND> listar();
}
