package com.sistema.examenes.repository;

import com.sistema.examenes.entity.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    public Usuario findByUsername(String username);
    
     @Query(value = "SELECT * FROM usuarios;", nativeQuery = true)
    public abstract List<Usuario> listaResponsables();
    @Query(value = "SELECT * FROM usuarios WHERE username=:user", nativeQuery = true)
     public Usuario buscarId(String user);
}
