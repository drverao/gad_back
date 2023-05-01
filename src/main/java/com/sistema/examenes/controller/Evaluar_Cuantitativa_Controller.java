package com.sistema.examenes.controller;

import com.sistema.examenes.entity.Evaluar_Cuantitativa;
import com.sistema.examenes.services.Evaluar_Cuantitativa_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/evaluar_indicador")
public class Evaluar_Cuantitativa_Controller {
    @Autowired
    Evaluar_Cuantitativa_Service Service;

    @PostMapping("/crear")
    public ResponseEntity<Evaluar_Cuantitativa> crear(@RequestBody Evaluar_Cuantitativa r) {
        try {

            return new ResponseEntity<>(Service.save(r), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Evaluar_Cuantitativa>> obtenerLista() {
        try {
            return new ResponseEntity<>(Service.findByAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Evaluar_Cuantitativa> getById(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(Service.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id, @RequestBody Evaluar_Cuantitativa evaluar_cuantitativa) {
        return Service.delete(id);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Evaluar_Cuantitativa> actualizar(@PathVariable Long id, @RequestBody Evaluar_Cuantitativa p) {
        Evaluar_Cuantitativa a = Service.findById(id);
        if (a == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                return new ResponseEntity<>(Service.save(a), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }
    }
}