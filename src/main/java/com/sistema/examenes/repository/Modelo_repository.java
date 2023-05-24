package com.sistema.examenes.repository;

import com.sistema.examenes.entity.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Modelo_repository extends JpaRepository<Modelo, Long> {
    @Query(value = "SELECT * from modelo order by id_modelo desc", nativeQuery = true)
    List<Modelo> listarModelo();

    @Query(value = "SELECT * FROM modelo WHERE id_modelo = (SELECT MAX(id_modelo) FROM modelo)", nativeQuery = true)
    public Modelo listarModeloMaximo();

    // SELECT id_modelo, fecha_fin, fecha_final_act, fecha_inicio, nombre, visible,
    // usuario_id
    // FROM public.modelo m
    // where m.visible=true and m.id_modelo!=:id_modelo;

    @Query(value = "SELECT * from modelo where visible =true and id_modelo!=:id_modelo", nativeQuery = true)
    List<Modelo> listarModeloExcepto(Long id_modelo);

}
