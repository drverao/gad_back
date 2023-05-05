package com.sistema.examenes.services;


import com.sistema.examenes.entity.Criterio;

import java.util.List;

public interface Criterio_Service extends GenericService<Criterio, Long>{

    public List<Criterio> listar() ;
}
