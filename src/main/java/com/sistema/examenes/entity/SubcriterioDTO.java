package com.sistema.examenes.entity;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SubcriterioDTO {
    private Long id_subcriterio;
    private String nombreSubcriterio;
    private String descripcionSubcriterio;
    private Set<IndicadorDTO> lista_indicadores = new HashSet<>();;
}
