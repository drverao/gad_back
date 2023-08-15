package com.sistema.examenes.entity;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PonderacionDTO {
   private Long idPonderacion;
   private double peso;
   private double valorObtenido;
   private double porcObtenido;
   private double porcUtilidadObtenida;
   private LocalDate fecha;
   private boolean visible;
   private Long criterioId;
   private String criterioNombre;
   private Long subcriterioId;
   private String subcriterioNombre;


}
