package com.sistema.examenes.controller;

import com.sistema.examenes.entity.Subcriterio;
import com.sistema.examenes.services.Subcriterio_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/subcriterio")
public class Subcriterio_Controller {
    @Autowired
    Subcriterio_Service Service;

    @PostMapping("/crear")
    public ResponseEntity<Subcriterio> crear(@RequestBody Subcriterio r) {
        try {
            r.setVisible(true);
            return new ResponseEntity<>(Service.save(r), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Subcriterio>> obtenerLista() {
        try {
            return new ResponseEntity<>(Service.listar(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Subcriterio> getById(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(Service.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        Subcriterio subcriterio = Service.findById(id);
        if (subcriterio == null) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                subcriterio.setVisible(false);
                return new ResponseEntity<>(Service.save(subcriterio), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Subcriterio> actualizar(@PathVariable Long id,@RequestBody Subcriterio p) {
        Subcriterio subcriterio = Service.findById(id);
        if (subcriterio == null) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                subcriterio.setNombre(p.getNombre());
                subcriterio.setDescripcion(p.getDescripcion());
                return new ResponseEntity<>(Service.save(subcriterio), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }
    }
}