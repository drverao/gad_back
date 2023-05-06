package com.sistema.examenes.services;

import com.sistema.examenes.entity.Actividad;
import com.sistema.examenes.entity.Asignacion_Indicador;
import com.sistema.examenes.repository.Asignacion_Indicador_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Asignacion_Indicador_ServiceImpl extends GenericServiceImpl<Asignacion_Indicador, Long> implements Asignacion_Indicador_Service {
    @Autowired
    private Asignacion_Indicador_repository repository;
    @Override
    public CrudRepository<Asignacion_Indicador, Long > getDao() {
        return repository;
    }
    @Override
    public List<Asignacion_Indicador> listar() {
        return repository.listarAsignacionIndicador();
    }
}
