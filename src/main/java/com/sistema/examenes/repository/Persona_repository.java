package com.sistema.examenes.repository;

import com.sistema.examenes.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Persona_repository extends JpaRepository<Persona, Long> {
}
