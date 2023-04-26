package com.sistema.examenes.controller;

import com.sistema.examenes.entity.Rol;
import com.sistema.examenes.entity.Usuario;
import com.sistema.examenes.entity.UsuarioRol;
import com.sistema.examenes.services.RolService;
import com.sistema.examenes.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RolService rolService;
    @PostConstruct
    public void init() {
        Rol usuario1 = new Rol(1L, "ADMIN");
        Rol usuario2 = new Rol(2L, "SUPERADMIN");
        Rol usuario3 = new Rol(3L, "RESPONSABLE");
        Rol usuario4 = new Rol(4L, "AUTORIDAD");

        rolService.save(usuario1);
        rolService.save(usuario2);
        rolService.save(usuario3);
        rolService.save(usuario4);
    }
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


    @PostMapping("/crear/{rolId}")
    public ResponseEntity<Usuario> crear(@RequestBody Usuario r, @PathVariable Long rolId) {
        try {
            // Buscar el rol por ID
            Rol rol = rolService.findById(rolId);

            // Crear un nuevo UsuarioRol y establecer las referencias correspondientes
            UsuarioRol usuarioRol = new UsuarioRol();
            usuarioRol.setUsuario(r);
            usuarioRol.setRol(rol);

            // Agregar el UsuarioRol a la lista de roles del usuario
            r.getUsuarioRoles().add(usuarioRol);

            // Guardar el usuario en la base de datos
            Usuario nuevoUsuario = usuarioService.save(r);

            return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
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
