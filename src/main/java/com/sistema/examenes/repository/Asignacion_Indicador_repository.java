package com.sistema.examenes.repository;

import com.sistema.examenes.entity.Asignacion_Indicador;
import com.sistema.examenes.entity.Criterio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


@Repository
public interface Asignacion_Indicador_repository extends JpaRepository<Asignacion_Indicador, Long> {

    @Query(value = "SELECT * from asignacion_indicador where visible =true", nativeQuery = true)
    List<Asignacion_Indicador> listarAsignacionIndicador();

    
    
    @Query(value = "SELECT m.id_modelo AS modelo_id, i.nombre AS indicador\n" +
"                 FROM modelo m\n" +
"                 JOIN asignacion_indicador ai ON m.id_modelo = ai.modelo_id_modelo\n" +
"                 JOIN indicador i ON ai.indicador_id_indicador = i.id_indicador", nativeQuery = true)
    public abstract List<Asignacion_Indicador> listaIndicador();

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Asignacion_Indicador> buscarIndicador() {
        String sql = "SELECT m.id_modelo AS modelo_id, i.nombre AS indicador\n"
                + "                 FROM modelo m\n"
                + "                 JOIN asignacion_indicador ai ON m.id_modelo = ai.modelo_id_modelo\n"
                + "                 JOIN indicador i ON ai.indicador_id_indicador = i.id_indicador;";
        return jdbcTemplate.query(sql, new RowMapper<Asignacion_Indicador>() {
            @Override
            public Asignacion_Indicador mapRow(ResultSet rs, int rowNum) throws SQLException {
                Asignacion_Indicador a_indicador = new Asignacion_Indicador
                );
        a_indicador.setModelo(a_indicador.getModelo());
                a_indicador.setIndicador(a_indicador.getIndicador());
                a_indicador.setId_asignacion_indicador(a_indicador.getId_asignacion_indicador()));
                
                return a_indicador;
            }
        });
    }

   
     @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public List< Asignacion_Indicador> getAllIndicador() {
        String sql = "SELECT m.id_modelo AS modelo_id, i.nombre AS indicador\n" +
"                 FROM modelo m\n" +
"                 JOIN asignacion_indicador ai ON m.id_modelo = ai.modelo_id_modelo\n" +
"                 JOIN indicador i ON ai.indicador_id_indicador = i.id_indicador;";
        List<Asignacion_Indicador> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Asignacion_Indicador.class));
        return users;
    }
}
