package com.sistema.examenes.controller;

import com.sistema.examenes.entity.Subcriterio;
import com.sistema.examenes.services.Subcriterio_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<Subcriterio> actualizar(@PathVariable Long id, @RequestBody Subcriterio p) {
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

    @GetMapping("/listarPorCriterio/{id_criterio}")
    public ResponseEntity<List<Subcriterio>> listarPorCriterio(@PathVariable("id_criterio") Long id_criterio) {
        try {
            return new ResponseEntity<>(Service.listarPorCriterio(id_criterio), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/listaSubcriteriosPorCriterio/{id_criterio}")
    public ResponseEntity<List<Map<String, Object>>> listaSubcriteriosPorCriterio(@PathVariable("id_criterio") Long id_criterio) {
        try {
            List<Map<String, Object>> subcriteriosData = Service.listarSubcriterioPorCriterioConDatosEspecificos(id_criterio);
            List<Map<String, Object>> responseList = new ArrayList<>();

            for (Map<String, Object> subcriterioData : subcriteriosData) {
                Map<String, Object> responseData = new HashMap<>();
                responseData.put("id_subcriterio", subcriterioData.get("id_subcriterio"));
                responseData.put("descripcion", subcriterioData.get("descripcion"));
                responseData.put("nombre", subcriterioData.get("nombre"));
                responseData.put("nombreCriterio", subcriterioData.get("nombreCriterio"));

                responseList.add(responseData);
            }

            return new ResponseEntity<>(responseList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}