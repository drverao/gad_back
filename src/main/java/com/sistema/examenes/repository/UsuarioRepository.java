package com.sistema.examenes.repository;

import com.sistema.examenes.entity.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    public Usuario findByUsername(String username);
    
     @Query(value = "SELECT u.id,u.enabled,u.password,u.username\n" +
"FROM usuarios u, usuario_rol ur\n" +
"WHERE ur.usuario_id=u.id and ur.rol_rol_id=3;", nativeQuery = true)
    public abstract List<Usuario> listaResponsables();
    @Query(value = "SELECT * FROM usuarios WHERE username=:user", nativeQuery = true)
     public Usuario buscarId(String user);
}
