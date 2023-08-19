package com.sistema.examenes.services;

import com.sistema.examenes.entity.Componente;

import java.util.List;

public interface Componente_Service extends GenericService<Componente, Long>{
    public List<Componente> listar();
}
