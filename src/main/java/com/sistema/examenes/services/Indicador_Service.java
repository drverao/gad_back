package com.sistema.examenes.services;

import com.sistema.examenes.entity.Indicador;

import java.util.List;

public interface Indicador_Service extends GenericService<Indicador, Long> {
    public List<Indicador> listar();

    public List<Indicador> listarPorSubcriterio(Long id_subcriterio);

}
