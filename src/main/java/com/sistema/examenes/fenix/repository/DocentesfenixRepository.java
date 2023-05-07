package com.sistema.examenes.fenix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sistema.examenes.fenix.entity.Docentesfenix;

public interface DocentesfenixRepository extends JpaRepository<Docentesfenix, String> {

    @Query("SELECT d FROM Docentesfenix d WHERE d.cedula = :cedula OR d.primer_apellido = :primer_apellido OR d.segundo_apellido = :segundo_apellido")
    List<Docentesfenix> findByCedulaAndApellidos(String cedula, String primer_apellido, String segundo_apellido);

    // metodo para listar todos los docentes
    List<Docentesfenix> findAll();

    // metodo para buscar un docente por su id
    List<Docentesfenix> findByCedula(String cedula);
}
