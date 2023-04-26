package com.sistema.examenes.controller;

import com.sistema.examenes.entity.Rol;
import com.sistema.examenes.entity.Usuario;
import com.sistema.examenes.entity.UsuarioRol;
import com.sistema.examenes.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

//    @PostMapping("/")
//    public Usuario guardarUsuario(@RequestBody Usuario usuario) throws Exception{
//        Set<UsuarioRol> usuarioRoles = new HashSet<>();
//
//        Rol rol = new Rol();
//        rol.setRolId(2L);
//        rol.setRolNombre("NORMAL");
//
//        UsuarioRol usuarioRol = new UsuarioRol();
//        usuarioRol.setUsuario(usuario);
//        usuarioRol.setRol(rol);
//
//        usuarioRoles.add(usuarioRol);
//        return usuarioService.guardarUsuario(usuario,usuarioRoles);
//    }


    @PostMapping("/")
    public ResponseEntity<Usuario> crear(@RequestBody Usuario r) {
        try {

            return new ResponseEntity<>(usuarioService.save(r), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Usuario>> obtenerLista() {
        try {
            return new ResponseEntity<>(usuarioService.findByAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(usuarioService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id, @RequestBody Usuario usuario) {
        return usuarioService.delete(id);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Usuario> actualizarCliente(@PathVariable Long id,@RequestBody Usuario p) {
        Usuario usu = usuarioService.findById(id);
        if (usu == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                return new ResponseEntity<>(usuarioService.save(usu), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }
    }

}
