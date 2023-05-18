package com.sistema.examenes.services;

import com.sistema.examenes.entity.Actividad;
import com.sistema.examenes.entity.Detalle_Evaluacion;
import com.sistema.examenes.repository.Detalle_Evaluacion_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Detalle_Evaluacion_ServiceImpl extends GenericServiceImpl<Detalle_Evaluacion, Long> implements Detalle_Evaluacion_Service {
    @Autowired
    private Detalle_Evaluacion_repository repository;
    @Override
    public CrudRepository<Detalle_Evaluacion, Long > getDao() {
        return repository;
    }

    @Override
    public List<Detalle_Evaluacion> listar() {
        return repository.listarDetalleEvaluacion();
    }

    @Override
    public List<Detalle_Evaluacion> listarDetalleEvaluacionRechazada(Long idEvidencia, Long idUsuario) {
        return repository.listarDetalleEvaluacionRechazada( idEvidencia, idUsuario);
    }

}
