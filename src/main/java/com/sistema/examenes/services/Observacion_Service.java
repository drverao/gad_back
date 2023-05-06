package com.sistema.examenes.services;

import com.sistema.examenes.entity.Observacion;

import java.util.List;

public interface Observacion_Service extends GenericService<Observacion, Long>{
    public List<Observacion> listar() ;

}
