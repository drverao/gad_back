package com.sistema.examenes.services;

import com.sistema.examenes.entity.Criterio;
import com.sistema.examenes.entity.Indicador;
import com.sistema.examenes.entity.Subcriterio;
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

    public List<Criterio> getCriteriosConSubcriteriosEIndicadores(Long id) {
        List<Criterio> criterios = repository.obtenerCriteriosPertenecientesAModelo(id);

        for (Criterio criterio : criterios) {
            criterio.setLista_subcriterios(new HashSet<>(criterio.getLista_subcriterios()));

            for (Subcriterio subcriterio : criterio.getLista_subcriterios()) {
                subcriterio.setLista_indicadores(new HashSet<>(subcriterio.getLista_indicadores()));
            }
        }

        return criterios;
    }


    public List<Criterio> obtenerCriteriosConSubcriteriosEIndicadores(Long id) {
        List<Object[]> resultados = repository.obtenerCriteriosConSubcriteriosEIndicadores(id);

        Map<Long, Criterio> criteriosMap = new HashMap<>();

        for (Object[] resultado : resultados) {
            Long idCriterio = ((BigInteger) resultado[0]).longValue();
            String nombreCriterio = (String) resultado[1];
            String descripcionCriterio = (String) resultado[2];
            boolean visibleCriterio = (boolean) resultado[3];

            Criterio criterioJSON = criteriosMap.get(idCriterio);
            if (criterioJSON == null) {
                criterioJSON = new Criterio();
                criterioJSON.setId_criterio(idCriterio);
                criterioJSON.setNombre(nombreCriterio);
                criterioJSON.setDescripcion(descripcionCriterio);
                criterioJSON.setVisible(visibleCriterio);
                criteriosMap.put(idCriterio, criterioJSON);
            }

            Long idSubcriterio = ((BigInteger) resultado[4]).longValue();
            String nombreSubcriterio = (String) resultado[5];
            String descripcionSubcriterio = (String) resultado[6];

            Subcriterio subcriterioJSON = new Subcriterio();
            subcriterioJSON.setId_subcriterio(idSubcriterio);
            subcriterioJSON.setNombre(nombreSubcriterio);
            subcriterioJSON.setDescripcion(descripcionSubcriterio);

            Long idIndicador = ((BigInteger) resultado[7]).longValue();
            String nombreIndicador = (String) resultado[8];
            String descripcionIndicador = (String) resultado[9];
            double peso = (double) resultado[10];
            double estandar = (double) resultado[11];
            double valorObtenido = (double) resultado[12];
            double porcObtenido = (double) resultado[13];
            double porcUtilidaObtenida = (double) resultado[14];
            String tipo = (String) resultado[15];

            Indicador indicadorJSON = new Indicador();
            indicadorJSON.setId_indicador(idIndicador);
            indicadorJSON.setNombre(nombreIndicador);
            indicadorJSON.setDescripcion(descripcionIndicador);
            indicadorJSON.setPeso(peso);
            indicadorJSON.setEstandar(estandar);
            indicadorJSON.setValor_obtenido(valorObtenido);
            indicadorJSON.setPorc_obtenido(porcObtenido);
            indicadorJSON.setPorc_utilida_obtenida(porcUtilidaObtenida);
            indicadorJSON.setTipo(tipo);

            // Agregar el indicador al subcriterio
            subcriterioJSON.getLista_indicadores().add(indicadorJSON);

            // Agregar el subcriterio al criterio
            criterioJSON.getLista_subcriterios().add(subcriterioJSON);
        }

        return new ArrayList<>(criteriosMap.values());
    }


}
