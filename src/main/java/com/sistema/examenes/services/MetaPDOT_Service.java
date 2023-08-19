package com.sistema.examenes.services;

import com.sistema.examenes.entity.MetaPDOT;

import java.util.List;

public interface MetaPDOT_Service extends GenericService<MetaPDOT, Long>{
    public List<MetaPDOT> listar();
}
