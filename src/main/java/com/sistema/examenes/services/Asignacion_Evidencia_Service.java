package com.sistema.examenes.services;

import com.sistema.examenes.entity.Asignacion_Evidencia;

import java.util.List;

public interface Asignacion_Evidencia_Service extends GenericService<Asignacion_Evidencia, Long>{
    public List<Asignacion_Evidencia> listar() ;

}
