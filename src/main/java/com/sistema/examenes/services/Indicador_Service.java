package com.sistema.examenes.services;

import com.sistema.examenes.entity.Indicador;
import com.sistema.examenes.entity.IndicadorDTO;

import java.util.List;

public interface Indicador_Service extends GenericService<Indicador, Long> {
    public List<Indicador> listar();

    public List<Indicador> listarPorSubcriterio(Long id_subcriterio);

    List<Indicador> obtenerIndicadores(Long id);

    List<Indicador> listarIndicadorPorCriterioModelo(Long id_criterio, Long id_modelo);

    List<Indicador> indicadoresPorCriterios(List<Long> id_criterio);

    List<IndicadorDTO> listarPorSubcriterioYVisible(Long id_subcriterio);

}
