package com.sistema.examenes.controller;

import com.sistema.examenes.entity.Usuario;
import com.sistema.examenes.entity.UsuarioRol;
import com.sistema.examenes.services.UsuarioRolService;
import com.sistema.examenes.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/usuariorol")
@CrossOrigin("*")
public class Usuario_Rol_Controller {
    @Autowired
    private UsuarioRolService usuarioService;
    @GetMapping("/listarv")
    public ResponseEntity<List<UsuarioRol>> obtenerLista() {
        try {
            System.out.println(usuarioService.listarv());

            return new ResponseEntity<>(usuarioService.listarv(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
