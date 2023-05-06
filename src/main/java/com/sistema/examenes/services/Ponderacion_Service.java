package com.sistema.examenes.services;

import com.sistema.examenes.entity.Ponderacion;

import java.util.List;

public interface Ponderacion_Service extends GenericService<Ponderacion, Long>{
    public List<Ponderacion> listar() ;

}
