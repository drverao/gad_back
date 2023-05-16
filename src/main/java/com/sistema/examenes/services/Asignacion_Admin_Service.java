package com.sistema.examenes.services;

import com.sistema.examenes.entity.Asignacion_Admin;

import java.util.List;

public interface Asignacion_Admin_Service extends GenericService<Asignacion_Admin, Long>{
    public List<Asignacion_Admin> listar() ;

}
