package com.sistema.examenes.services;


import com.sistema.examenes.entity.Actividad;

import java.util.List;

public interface Actividad_Service extends GenericService<Actividad, Long>{
    public List<Actividad> listar() ;
}
