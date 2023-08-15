package com.sistema.examenes.entity;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CriterioDTO {
   private Long id_criterio;
   private String nombreCriterio;
   private String descripcionCriterio;
   private Set<SubcriterioDTO> lista_subcriterios = new HashSet<>();

}
