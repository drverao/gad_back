package com.sistema.examenes.services;

import com.sistema.examenes.entity.Trimestre;

import java.util.List;

public interface Trimestre_Service extends GenericService<Trimestre, Long>{
    public List<Trimestre> listar();
}
