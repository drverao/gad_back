package com.sistema.examenes.services;

import com.sistema.examenes.entity.DetalleTrimestre;

import java.util.List;

public interface DetalleTrimestre_Service extends GenericService<DetalleTrimestre, Long>{
    public List<DetalleTrimestre> listar();
}
