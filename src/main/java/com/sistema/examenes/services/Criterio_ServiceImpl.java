package com.sistema.examenes.services;

import com.sistema.examenes.entity.*;
import com.sistema.examenes.repository.Criterio_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.*;

@Service
public class Criterio_ServiceImpl extends GenericServiceImpl<Criterio, Long> implements Criterio_Service {

    @Autowired
    private Criterio_repository repository;

    @Override
    public CrudRepository<Criterio, Long> getDao() {

        return repository;
    }

    @Override
    public List<Criterio> listar() {
        return repository.listarCriterio();
    }

    @Override
    public List<Criterio> obtenerCriterios() {
        return repository.obtenerCriterios();
    }

    @Override
    public List<Criterio> obtenerCriteriosUltimoModelo() {
        return repository.obtenerCriteriosUltimoModelo();
    }

    @Override
    public List<Criterio> obtenerCriterioModelo() {
        return repository.obtenerCriteriosModelo();
    }

    public List<Criterio> obtenerCriterioIdModelo(Long id) {
        return repository.obtenerCriteriosModeloId(id);
    }

    public List<Criterio> obtenerCriterioPertenecientesAModelo(Long id) {
        return repository.obtenerCriteriosPertenecientesAModelo(id);
    }
    @Override
    public List<Criterio> listarCriterioPorIndicador(Long id_indicador) {
        return repository.listarCriterioPorIndicador(id_indicador);
    }

    @Override
    public List<CriterioDTO> obtenerCSI(Long id_modelo) {
        List<CriterioDTO> criteriosDTO = new ArrayList<>();
        List<Object[]> resultados = repository.obtenerCSI(id_modelo);

        for (Object[] resultado : resultados) {
            Long idCriterio = ((BigInteger) resultado[0]).longValue();
            String nombreCriterio = (String) resultado[1];
            String descripcionCriterio = (String) resultado[2];

            Long idSubcriterio = ((BigInteger) resultado[3]).longValue();
            String nombreSubcriterio = (String) resultado[4];
            String descripcionSubcriterio = (String) resultado[5];

            Long idIndicador = ((BigInteger) resultado[6]).longValue();
            String nombreIndicador = (String) resultado[7];
            String descripcionIndicador = (String) resultado[8];
            double peso = (double) resultado[9];
            double estandar = (double) resultado[10];
            double valorObtenido = (double) resultado[11];
            double porcObtenido = (double) resultado[12];
            double porcUtilidaObtenida = (double) resultado[13];
            String tipo = (String) resultado[14];

            // Buscar el criterioDTO en la lista existente o crear uno nuevo si no existe
            CriterioDTO criterioDTO = criteriosDTO.stream()
                    .filter(c -> c.getId_criterio().equals(idCriterio))
                    .findFirst()
                    .orElse(new CriterioDTO());
            criterioDTO.setId_criterio(idCriterio);
            criterioDTO.setNombreCriterio(nombreCriterio);
            criterioDTO.setDescripcionCriterio(descripcionCriterio);

            // Buscar el subcriterioDTO en la lista existente o crear uno nuevo si no existe
            SubcriterioDTO subcriterioDTO = criterioDTO.getLista_subcriterios().stream()
                    .filter(sc -> sc.getId_subcriterio().equals(idSubcriterio))
                    .findFirst()
                    .orElse(new SubcriterioDTO());
            subcriterioDTO.setId_subcriterio(idSubcriterio);
            subcriterioDTO.setNombreSubcriterio(nombreSubcriterio);
            subcriterioDTO.setDescripcionSubcriterio(descripcionSubcriterio);

            // Crear un nuevo indicadorDTO y agregarlo a la lista de indicadores del subcriterioDTO
            IndicadorDTO indicadorDTO = new IndicadorDTO();
            indicadorDTO.setId_indicador(idIndicador);
            indicadorDTO.setNombre(nombreIndicador);
            indicadorDTO.setDescripcion(descripcionIndicador);
            indicadorDTO.setPeso(peso);
            indicadorDTO.setEstandar(estandar);
            indicadorDTO.setValor_obtenido(valorObtenido);
            indicadorDTO.setPorc_obtenido(porcObtenido);
            indicadorDTO.setPorc_utilida_obtenida(porcUtilidaObtenida);
            indicadorDTO.setTipo(tipo);

            // Agregar el indicadorDTO a la lista de indicadores del subcriterioDTO
            subcriterioDTO.getLista_indicadores().add(indicadorDTO);

            // Agregar el subcriterioDTO a la lista de subcriterios del criterioDTO
            criterioDTO.getLista_subcriterios().add(subcriterioDTO);

            // Agregar el criterioDTO a la lista de criteriosDTO si es la primera vez que se encuentra
            if (!criteriosDTO.contains(criterioDTO)) {
                criteriosDTO.add(criterioDTO);
            }
        }

        return criteriosDTO;
    }
}
