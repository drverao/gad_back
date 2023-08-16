package com.sistema.examenes.services;

import com.sistema.examenes.entity.ObjetivoODS;
import com.sistema.examenes.entity.Programa;

import java.util.List;

public interface Programa_Service extends GenericService<Programa, Long>{
    public List<Programa> listar();
}
