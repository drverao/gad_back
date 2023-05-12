package com.sistema.examenes.services;


import com.sistema.examenes.entity.Archivo_s;
import com.sistema.examenes.entity.Evidencia;

import java.util.List;

public interface Archivo_Service extends GenericService<Archivo_s, Long>{
    public List<Archivo_s> listar() ;


}
