package com.sistema.examenes.repository;

import com.sistema.examenes.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Persona_repository extends JpaRepository<Persona, Long> {
    @Query(value = "SELECT * FROM persona p JOIN usuarios u ON p.id_persona = u.persona_id_persona WHERE u.username = :username", nativeQuery = true)
    public Persona obtenerPersona(String username);

@Query(value = "select * from persona per join usuarios u on per.id_persona = u.persona_id_persona\n" +
        "join actividad ac on ac.usuario_id = u.id join archivo ar on ar.id_actividad=ac.id_actividad and ar.visible =true", nativeQuery = true)
    List<Persona>listarcorreos();

}
