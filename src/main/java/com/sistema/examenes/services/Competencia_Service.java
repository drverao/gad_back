package com.sistema.examenes.services;

import com.sistema.examenes.entity.Competencia;

import java.util.List;

public interface Competencia_Service extends GenericService<Competencia, Long>{
    public List<Competencia> listar();
}
