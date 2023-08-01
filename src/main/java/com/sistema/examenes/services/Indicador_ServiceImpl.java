package com.sistema.examenes.services;

import com.sistema.examenes.entity.Indicador;
import com.sistema.examenes.entity.IndicadorDTO;
import com.sistema.examenes.repository.Indicador_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Indicador_ServiceImpl extends GenericServiceImpl<Indicador, Long> implements Indicador_Service {
    @Autowired
    private Indicador_repository repository;

    @Override
    public CrudRepository<Indicador, Long> getDao() {

        return repository;
    }

    @Override
    public List<Indicador> listar() {
        return repository.listarIndicador();
    }

    @Override
    public List<Indicador> listarPorSubcriterio(Long id_subcriterio) {
        return repository.listarIndicadorPorSubcriterio(id_subcriterio);
    }

    @Override
    public List<Indicador> obtenerIndicadores(Long id) {
        return repository.obtenerIndicadores(id);
    }

    @Override
    public List<Indicador> listarIndicadorPorCriterioModelo(Long id_criterio, Long id_modelo) {
        return repository.listarIndicadorPorCriterioModelo(id_criterio, id_modelo);
    }

    @Override
    public List<Indicador> indicadoresPorCriterios(List<Long> id_criterio) {
        return repository.indicadoresPorCriterios(id_criterio);
    }

    @Override
    public List<IndicadorDTO> listarPorSubcriterioYVisible(Long id_subcriterio) {
        List<Indicador> indicadores = repository.listarIndicadorPorSubcriterioYVisible(id_subcriterio);
        List<IndicadorDTO> indicadoresDTO = indicadores.stream().map(indicador -> {
            IndicadorDTO dto = new IndicadorDTO();
            dto.setId_indicador(indicador.getId_indicador());
            dto.setNombre(indicador.getNombre());
            dto.setDescripcion(indicador.getDescripcion());
            dto.setPeso(indicador.getPeso());
            dto.setEstandar(indicador.getEstandar());
            dto.setValor_obtenido(indicador.getValor_obtenido());
            dto.setPorc_obtenido(indicador.getPorc_obtenido());
            dto.setPorc_utilida_obtenida(indicador.getPorc_utilida_obtenida());
            dto.setTipo(indicador.getTipo());
            dto.setNombreCriterio(indicador.getSubcriterio().getCriterio().getNombre());
            dto.setNombreSubcriterio(indicador.getSubcriterio().getNombre());
            return dto;
        }).collect(Collectors.toList());
        return indicadoresDTO;
    }
}
