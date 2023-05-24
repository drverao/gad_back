package com.sistema.examenes.services;

import com.sistema.examenes.entity.Subcriterio;
import com.sistema.examenes.entity.UsuarioRol;
import com.sistema.examenes.repository.UsuarioRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioRolServiceImpl extends GenericServiceImpl<UsuarioRol, Long> implements UsuarioRolService{
    @Autowired
    private UsuarioRolRepository usuarioRolRepository;
    @Override
    public CrudRepository<UsuarioRol, Long> getDao() {
        return usuarioRolRepository;
    }

    @Override
    public List<UsuarioRol> listarv() {
        return usuarioRolRepository.listarv();
    }
}
