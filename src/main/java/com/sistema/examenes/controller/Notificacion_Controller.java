package com.sistema.examenes.controller;

import com.sistema.examenes.entity.Notificacion;
import com.sistema.examenes.services.NotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

import static java.lang.String.valueOf;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/notificacion")
public class Notificacion_Controller {
    @Autowired
    NotificacionService service;

    @PostMapping("/crear")
    public ResponseEntity<Notificacion> crear(@RequestBody Notificacion not){
        try {
            not.setVisto(false);
            return new ResponseEntity<>(service.save(not), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/listarnotificaciones/{id}")
    public ResponseEntity<List<Notificacion>>listar(@PathVariable("id") Long id){
        try {
            return new ResponseEntity<>(service.listar(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/listartodo/{roluser}")
    public ResponseEntity<List<Notificacion>>obtenerLista(@PathVariable("roluser") String roluser) {
        try {
            return new ResponseEntity<>(service.all(roluser), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id) {
        Notificacion notificacion=service.findById(id);
        if (notificacion == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                notificacion.setVisto(true);
                System.out.println("actualizado");
                return new ResponseEntity<>(service.save(notificacion), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }
    }
    @Scheduled(cron = "0 0 0 * * ?") // se ejecuta una vez al día a la medianoche
    public void eliminarNotificacionesAntiguas() {
        LocalDate hoy = LocalDate.now();
        LocalDate fechaLimite = hoy.minusDays(45);
        String fecha=String.valueOf(fechaLimite);
        List<Notificacion> notificacionesAntiguas = service.listarNotifi(fecha);
        for (Notificacion notificacion : notificacionesAntiguas) {
            service.eliminar(notificacion.getId());
        }
    }



}
