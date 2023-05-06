package com.sistema.examenes.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.examenes.fenix.repository.DocentesfenixRepository;
import com.sistema.examenes.fenix.entity.Docentesfenix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//Controller para fenix
@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/fenix")
public class FenixController {

    // metodos para el controlador de fenix
    @Autowired
    DocentesfenixRepository docentefenixRepository;

    // // Metodos para buscar por cedula, primer apellido y segundo apellido

    // @GetMapping(path = { "/{cedula}" })
    // public Docentesfenix findByCedula(@PathVariable("cedula") String cedula) {
    // return docentefenixRepository.findByCedula(cedula);
    // }

    // @GetMapping(path = { "/{primer_apellido}" })
    // public List<Docentesfenix>
    // findByPrimerApellido(@PathVariable("primer_apellido") String primer_apellido)
    // {
    // return docentefenixRepository.findByPrimerApellido(primer_apellido);
    // }

    // @GetMapping(path = { "/{segundo_apellido}" })
    // public List<Docentesfenix>
    // findBySegundoApellido(@PathVariable("segundo_apellido") String
    // segundo_apellido) {
    // return docentefenixRepository.findBySegundoApellido(segundo_apellido);
    // }

    // metodo para listar todos los docentes
    @GetMapping(path = { "/listar" })
    public List<Docentesfenix> findAll() {
        return docentefenixRepository.findAll();
    }

    // metodo para buscar docente por cedula
    @GetMapping(path = { "/buscar/{cedula}" })
    public Docentesfenix findByCedula(@PathVariable("cedula") String cedula) {
        return docentefenixRepository.findByCedula(cedula);
    }
}
