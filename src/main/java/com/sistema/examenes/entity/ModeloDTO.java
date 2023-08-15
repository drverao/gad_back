package com.sistema.examenes.entity;

import lombok.*;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ModeloDTO {
    private Long id_modelo;
    private String nombreModelo;
    private Date fechaInicio;
    private Date fechaFin;
    private Date fechaFinalAct;
    private List<CriterioDTO> criterios = new ArrayList<>();
}
