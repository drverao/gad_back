package com.sistema.examenes.services;

import com.sistema.examenes.entity.Actividad;
import com.sistema.examenes.entity.Ponderacion;
import com.sistema.examenes.entity.PonderacionDTO;
import com.sistema.examenes.repository.Ponderacion_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class Ponderacion_ServiceImpl extends GenericServiceImpl<Ponderacion, Long> implements Ponderacion_Service {
    @Autowired
    private Ponderacion_repository repository;

    @Override
    public CrudRepository<Ponderacion, Long> getDao() {
        return repository;
    }

    @Override
    public List<Ponderacion> listar() {
        return repository.listarPonderacion();
    }

    @Override
    public List<Ponderacion> listarPorFecha(String fecha) {
        return repository.listarPorFecha(fecha);
    }

    @Override
    public List<Date> listarPonderacionPorModelo(Long id_modelo) {
        return repository.listarPonderacionPorModelo(id_modelo);
    }

    @Override
    public List<Ponderacion> listarPonderacionPorFecha(String fecha) {
        return repository.listarPonderacionPorFecha(fecha);
    }
    @Override
    public List<PonderacionDTO> listarPonderacionConCriterioYSubcriterioDTO() {
        List<Object[]> results = repository.listarPonderacionConCriterioYSubcriterio();
        List<PonderacionDTO> dtos = new ArrayList<>();

        for (Object[] result : results) {
            Ponderacion p = (Ponderacion) result[0];
            Long criterioId = (Long) result[1];
            String criterioNombre = (String) result[2];
            Long subcriterioId = (Long) result[3];
            String subcriterioNombre = (String) result[4];

            PonderacionDTO dto = new PonderacionDTO();
            dto.setIdPonderacion(p.getId_ponderacion());
            dto.setPeso(p.getPeso());
            dto.setValorObtenido(p.getValor_obtenido());
            dto.setPorcObtenido(p.getPorc_obtenido());
            dto.setPorcUtilidadObtenida(p.getPorc_utilida_obtenida());
            dto.setFecha(p.getFecha());
            dto.setVisible(p.isVisible());
            dto.setCriterioId(criterioId);
            dto.setCriterioNombre(criterioNombre);
            dto.setSubcriterioId(subcriterioId);
            dto.setSubcriterioNombre(subcriterioNombre);

            dtos.add(dto);
        }

        return dtos;
    }

}
