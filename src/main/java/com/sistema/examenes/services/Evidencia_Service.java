package com.sistema.examenes.services;


import com.sistema.examenes.entity.Evidencia;

import java.util.List;

public interface Evidencia_Service extends GenericService<Evidencia, Long>{
    public List<Evidencia> listar() ;
    public List<Evidencia> evidenciaUsuario(String username);

}
