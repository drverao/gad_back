package com.sistema.examenes.services;


import com.sistema.examenes.entity.Actividad;

import java.util.List;


public interface Actividad_Service extends GenericService<Actividad, Long>{
    public List<Actividad> listar() ;

    public List<Actividad> listaAtrasada();
    public List<Actividad> listaCumplida();
    public List<Actividad> listarporusuario(String username);
    List<Actividad> findByNombreContainingIgnoreCase(String nombre);
    public List<Actividad>listarporEvidencia(Long idEvidencia );
    public List<Actividad> listaEvidAtrasada();


}

