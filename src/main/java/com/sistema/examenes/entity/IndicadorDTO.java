package com.sistema.examenes.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class IndicadorDTO {
   private Long id_indicador;
   private String  nombre;
   private String  descripcion;
   private double  peso;
   private double estandar;
   private double valor_obtenido;
   private double porc_obtenido;
   private double porc_utilida_obtenida;
   private String tipo;
   private String nombreCriterio;
   private String nombreSubcriterio;

}
