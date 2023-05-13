package com.sistema.examenes.repository;

import com.sistema.examenes.entity.Evidencia;
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

    @Query(value = "SELECT *\n" +
            "FROM usuarios u\n" +
            "JOIN asignacion_evidencia ae ON u.id = ae.usuario_id\n" +
            "JOIN persona p  ON u.persona_id_persona = p.id_persona\n" +
            "WHERE u.visible = true AND ae.visible = true;",nativeQuery = true)
    public List<Usuario> listaResponsablesDatos();


}
