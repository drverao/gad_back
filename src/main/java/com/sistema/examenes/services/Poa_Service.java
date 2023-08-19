package com.sistema.examenes.services;

import com.sistema.examenes.entity.Poa;

import java.util.List;

public interface Poa_Service extends GenericService<Poa, Long>{
    public List<Poa> listar();
}
