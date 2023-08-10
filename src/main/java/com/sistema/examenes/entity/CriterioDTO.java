package com.sistema.examenes.entity;

import lombok.*;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CriterioDTO {
   private Long id_criterio;
   private String nombreCriterio;
   private String descripcionCriterio;
   private List<SubcriterioDTO> lista_subcriterios = new ArrayList<>();
}
