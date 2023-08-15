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

    public List<ModeloDTO> obtenerCSIConModelo(Long id_modelo) {
        List<ModeloDTO> modelosDTO = new ArrayList<>();
        List<Object[]> resultados = repository.obtenerCSIConModelo(id_modelo);

        Map<Long, ModeloDTO> modelosMap = new HashMap<>();

        for (Object[] resultado : resultados) {
            Long idModelo = ((BigInteger) resultado[0]).longValue();
            String nombreModelo = (String) resultado[1];
            Date fechaInicioModelo = (Date) resultado[2];
            Date fechaFinModelo = (Date) resultado[3];
            Date fechaFinalActModelo = (Date) resultado[4];

            // Obtener o crear el modeloDTO
            ModeloDTO modeloDTO = modelosMap.computeIfAbsent(idModelo, id -> {
                ModeloDTO modelo = new ModeloDTO();
                modelo.setId_modelo(idModelo);
                modelo.setNombreModelo(nombreModelo);
                modelo.setFechaInicio(fechaInicioModelo);
                modelo.setFechaFin(fechaFinModelo);
                modelo.setFechaFinalAct(fechaFinalActModelo);
                modelo.setCriterios(new ArrayList<>());
                return modelo;
            });

            CriterioDTO criterioDTO = new CriterioDTO();
            Long idCriterio = ((BigInteger) resultado[5]).longValue();
            criterioDTO.setId_criterio(idCriterio);
            criterioDTO.setNombreCriterio((String) resultado[6]);
            criterioDTO.setDescripcionCriterio((String) resultado[7]);

            SubcriterioDTO subcriterioDTO = new SubcriterioDTO();
            Long idSubcriterio = ((BigInteger) resultado[8]).longValue();
            subcriterioDTO.setId_subcriterio(idSubcriterio);
            subcriterioDTO.setNombreSubcriterio((String) resultado[9]);
            subcriterioDTO.setDescripcionSubcriterio((String) resultado[10]);

            IndicadorDTO indicadorDTO = new IndicadorDTO();
            indicadorDTO.setId_indicador(((BigInteger) resultado[11]).longValue());
            indicadorDTO.setNombre((String) resultado[12]);
            indicadorDTO.setDescripcion((String) resultado[13]);
            indicadorDTO.setPeso((double) resultado[14]);
            indicadorDTO.setEstandar((double) resultado[15]);
            indicadorDTO.setValor_obtenido((double) resultado[16]);
            indicadorDTO.setPorc_obtenido((double) resultado[17]);
            indicadorDTO.setPorc_utilida_obtenida((double) resultado[18]);
            indicadorDTO.setTipo((String) resultado[19]);

            CriterioDTO criterioExistente = modeloDTO.getCriterios().stream()
                    .filter(c -> c.getId_criterio().equals(idCriterio))
                    .findFirst()
                    .orElse(criterioDTO);

            // Buscar el subcriterioDTO en la lista existente o crear uno nuevo si no existe
            SubcriterioDTO subcriterioExistente = criterioExistente.getLista_subcriterios().stream()
                    .filter(sc -> sc.getId_subcriterio().equals(idSubcriterio))
                    .findFirst()
                    .orElse(subcriterioDTO);

            // Agregar el indicadorDTO al subcriterioDTO
            subcriterioExistente.getLista_indicadores().add(indicadorDTO);

            // Agregar el subcriterioDTO al criterioDTO
            criterioExistente.getLista_subcriterios().add(subcriterioExistente);

            // Agregar el criterioDTO al modeloDTO si es la primera vez que se encuentra
            if (!modeloDTO.getCriterios().contains(criterioDTO)) {
                modeloDTO.getCriterios().add(criterioDTO);
            }
        }
        return new ArrayList<>(modelosMap.values());
    }

}
