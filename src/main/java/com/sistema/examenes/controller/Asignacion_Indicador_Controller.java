package com.sistema.examenes.controller;

import com.sistema.examenes.entity.Asignacion_Indicador;
import com.sistema.examenes.entity.Criterio;
import com.sistema.examenes.entity.Usuario;
import com.sistema.examenes.services.Asignacion_Indicador_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sistema.examenes.repository.Asignacion_Indicador_repository;

import java.util.List;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/asignacion_criterio")
public class Asignacion_Indicador_Controller {
    @Autowired
    Asignacion_Indicador_Service Service;
    
    
   
  
    @Autowired
   Asignacion_Indicador_repository asignacion_Rep;
    
    
      @GetMapping("/listarIndicador")
    public ResponseEntity<List<Asignacion_Indicador>> obtenerListaIndicadores() {
        try {     
           //List<Usuario> responsables = uR.listaResponsables();
            return new ResponseEntity<>(asignacion_Rep.listaIndicador(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/crear")
    public ResponseEntity<Asignacion_Indicador> crear(@RequestBody Asignacion_Indicador r) {
        try {
            r.setVisible(true);

            return new ResponseEntity<>(Service.save(r), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Asignacion_Indicador>> obtenerLista() {
        try {
            return new ResponseEntity<>(Service.findByAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/listarv")
    public ResponseEntity<List<Asignacion_Indicador>> obtenerListav() {
        try {
            return new ResponseEntity<>(Service.listar(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Asignacion_Indicador> getById(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(Service.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        return Service.delete(id);
    }
    @PutMapping("/eliminarlogic/{id}")
    public ResponseEntity<?> eliminarlogic(@PathVariable Long id) {
        Asignacion_Indicador a = Service.findById(id);
        if (a == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                a.setVisible(false);
                return new ResponseEntity<>(Service.save(a), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }
    }
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Asignacion_Indicador> actualizar(@PathVariable Long id, @RequestBody Asignacion_Indicador p) {
        Asignacion_Indicador a = Service.findById(id);
        if (a == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                a.setModelo(p.getModelo());
                a.setIndicador(p.getIndicador());
                return new ResponseEntity<>(Service.save(a), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }
    }
}