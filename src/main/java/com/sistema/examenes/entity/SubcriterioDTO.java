package com.sistema.examenes.entity;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
    private List<IndicadorDTO> lista_indicadores = new ArrayList<>();
}
