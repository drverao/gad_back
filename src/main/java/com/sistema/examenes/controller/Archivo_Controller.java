package com.sistema.examenes.controller;

import com.sistema.examenes.entity.Archivo;
import com.sistema.examenes.entity.Evidencia;
import com.sistema.examenes.mensajes.Archivosmensajes;
import com.sistema.examenes.services.Archivoservices;
import com.sistema.examenes.services.Evidencia_Service;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@RestController
@CrossOrigin(origins = { "*" })
@RequestMapping("archivo")
@AllArgsConstructor
public class Archivo_Controller {
    @Autowired
    Archivoservices servis;
@Autowired
    Evidencia_Service eviservis;
 @Autowired
  HttpServletRequest request;
    @PostMapping("/upload")
    public ResponseEntity<Archivosmensajes> upload(@RequestParam("file") MultipartFile[] files) {
        String meNsaje = "";
        try {
            List<String> fileNames = new ArrayList<>();
            Arrays.asList(files).stream().forEach(file -> {
                servis.guardar(file);
                fileNames.add(file.getOriginalFilename());

             });
            String host = request.getRequestURL().toString().replace(request.getRequestURI(), "");
            String url = ServletUriComponentsBuilder.fromHttpUrl(host)
                    .path("/archivo/").path(fileNames.get(0)).toUriString();
            eviservis.save(new Evidencia(""+url,""+fileNames,true));
            meNsaje = "se subieron correctamente" + fileNames;
            return ResponseEntity.status(HttpStatus.OK).body(new Archivosmensajes(meNsaje+"url:"+url));
        } catch (Exception e) {
            meNsaje = " fallo al subir";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new Archivosmensajes(meNsaje));
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Archivo>> getFiles() {
        List<Archivo> archivos = servis.lIstar().map(path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder.fromMethodName(Archivo_Controller.class, "getFile"
                    , path.getFileName().toString()).build().toString();

            return new Archivo(filename, url);

        }).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(archivos);
    }
@GetMapping ("{filename:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String filename){
        Resource file=servis.load(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION
        ,"attachment; filename=\""+file.getFilename()+ "\"").body(file);
        }

    @GetMapping ("/borrar/{filename:.+}")
    public ResponseEntity<Archivosmensajes> borrar(@PathVariable String filename)
    {
        String mensaje="";
        try {
            mensaje= servis.borrar(filename);
            return ResponseEntity.status(HttpStatus.OK).body(new Archivosmensajes(mensaje));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new Archivosmensajes(mensaje));
        }
    }


}
























