package com.sistema.examenes.services;

import com.sistema.examenes.entity.Evidencias;

import java.util.List;

public interface Evidencias_Service extends GenericService<Evidencias, Long>{
    public List<Evidencias> listar();
}
