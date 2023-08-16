package com.sistema.examenes.services;

import com.sistema.examenes.entity.EjePND;
import com.sistema.examenes.entity.ObjetivoPDOT;

import java.util.List;

public interface ObjetivoPDOT_Service extends GenericService<ObjetivoPDOT, Long>{
    public List<ObjetivoPDOT> listar();
}
