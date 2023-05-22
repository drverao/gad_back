package com.sistema.examenes.services;

import com.sistema.examenes.entity.Usuario;

import java.util.List;

public interface UsuarioService extends GenericService<Usuario, Long> {
    public Usuario obtenerUsuario(String username);

    public Usuario obtenerId(String username);

    // public List<Usuario> listaAdminDatos(); de repository
    public List<Usuario> listaAdminDatos();
}
