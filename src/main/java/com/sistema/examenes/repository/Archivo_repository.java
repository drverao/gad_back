package com.sistema.examenes.repository;

import com.sistema.examenes.entity.Archivo_s;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Archivo_repository extends JpaRepository<Archivo_s, Long> {
    @Query(value = "SELECT * from archivo where visible =true",nativeQuery = true)
    List<Archivo_s> listararchivo();
    @Query(value = "select * from archivo ar join actividad ac on ar.id_actividad=ac.id_actividad\n" +
    "JOIN usuarios u ON ac.usuario_id = u.id where u.username=:username and ar.visible =true",nativeQuery = true)
    public List<Archivo_s> listararchivouser(String username);
    @Query(value = "SELECT * FROM archivo WHERE visible = true AND  id_actividad=:idActividad",nativeQuery = true)
    public List<Archivo_s> listararchivoActividad(Long idActividad);
}
