package com.sistema.examenes.services;

import com.sistema.examenes.entity.Usuario;
import com.sistema.examenes.entity.UsuarioRol;

import java.util.Set;

public interface UsuarioService extends GenericService<Usuario, Long>{
    public Usuario obtenerUsuario(String username);
}
