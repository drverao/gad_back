package com.sistema.examenes.services;

import com.sistema.examenes.entity.Criterio;
import com.sistema.examenes.entity.CriterioDTO;
import com.sistema.examenes.entity.IndicadorDTO;
import com.sistema.examenes.entity.ModeloDTO;

import java.util.List;

public interface Criterio_Service extends GenericService<Criterio, Long> {

    public List<Criterio> listar();

    public List<Criterio> obtenerCriterios();

    public List<Criterio> obtenerCriterioModelo();

    public List<Criterio> obtenerCriterioIdModelo(Long id);

    public List<Criterio> obtenerCriteriosUltimoModelo();

    // listarCriterioPorIndicador de repositorio
    public List<Criterio> listarCriterioPorIndicador(Long id_indicador);

    public List<Criterio> obtenerCriterioPertenecientesAModelo(Long id);

    List<ModeloDTO> obtenerCSIConModelo(Long id_modelo);
}
