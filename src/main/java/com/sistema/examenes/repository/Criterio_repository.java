package com.sistema.examenes.repository;

import com.sistema.examenes.entity.Criterio;
import com.sistema.examenes.entity.CriterioDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Criterio_repository extends JpaRepository<Criterio, Long> {

        @Query(value = "SELECT * from criterio where visible =true", nativeQuery = true)
        List<Criterio> listarCriterio();

        @Query(value = "SELECT c.id_criterio, c.nombre, c.descripcion, c.visible FROM indicador i JOIN subcriterio s "
                        + "ON s.id_subcriterio = i.subcriterio_id_subcriterio JOIN criterio c "
                        + "ON c.id_criterio = s.id_criterio where c.visible =true GROUP BY c.id_criterio, c.nombre ORDER BY c.id_criterio;", nativeQuery = true)
        public List<Criterio> obtenerCriterios();

        @Query(value = "SELECT c.id_criterio, c.nombre, c.descripcion, c.visible FROM asignacion_indicador ag\n"
                        + "JOIN indicador i ON ag.indicador_id_indicador = i.id_indicador\n"
                        + "JOIN subcriterio s ON s.id_subcriterio = i.subcriterio_id_subcriterio \n"
                        + "JOIN criterio c ON c.id_criterio = s.id_criterio \n"
                        + "WHERE ag.modelo_id_modelo = (SELECT MAX(id_modelo) FROM modelo)\n"
                        + "GROUP BY c.id_criterio, c.nombre ORDER BY c.id_criterio;", nativeQuery = true)
        public List<Criterio> obtenerCriteriosModelo();

        @Query(value = "SELECT c.id_criterio, c.nombre, c.descripcion, c.visible FROM asignacion_indicador ag\n"
                        + "JOIN indicador i ON ag.indicador_id_indicador = i.id_indicador\n"
                        + "JOIN subcriterio s ON s.id_subcriterio = i.subcriterio_id_subcriterio \n"
                        + "JOIN criterio c ON c.id_criterio = s.id_criterio \n"
                        + "WHERE ag.modelo_id_modelo = :modelo\n"
                        + "GROUP BY c.id_criterio, c.nombre ORDER BY c.id_criterio;", nativeQuery = true)
        public List<Criterio> obtenerCriteriosModeloId(Long modelo);

        // @Query(value = "SELECT DISTINCT c.id_criterio, c.nombre, c.descripcion,
        // c.visible " +
        // "FROM criterio c " +
        // "JOIN subcriterio s ON c.id_criterio = s.id_criterio " +
        // "JOIN indicador i ON s.id_subcriterio = i.subcriterio_id_subcriterio " +
        // "JOIN asignacion_indicador ai ON i.id_indicador = ai.indicador_id_indicador "
        // +
        // "WHERE ai.modelo_id_modelo = (SELECT MAX(m.id_modelo) FROM modelo m)",
        // nativeQuery = true)
        // List<Criterio> obtenerCriteriosUltimoModelo();

        // @Query(value = "SELECT * from criterio where visible =true", nativeQuery =
        // true)
        // List<Criterio> listarCriterio();

        // @Query(value = "SELECT c.id_criterio, c.nombre, c.descripcion, c.visible FROM
        // indicador i JOIN subcriterio s " +
        // "ON s.id_subcriterio = i.subcriterio_id_subcriterio JOIN criterio c " +
        // "ON c.id_criterio = s.id_criterio where c.visible =true GROUP BY
        // c.id_criterio, c.nombre ORDER BY c.id_criterio;", nativeQuery = true)
        // public List<Criterio> obtenerCriterios();

        @Query(value = "SELECT DISTINCT c.id_criterio, c.nombre, c.descripcion, c.visible " +
                        "FROM criterio c " +
                        "JOIN subcriterio s ON c.id_criterio = s.id_criterio " +
                        "JOIN indicador i ON s.id_subcriterio = i.subcriterio_id_subcriterio " +
                        "JOIN asignacion_indicador ai ON i.id_indicador = ai.indicador_id_indicador " +
                        "WHERE ai.modelo_id_modelo = (SELECT MAX(m.id_modelo) FROM modelo m)", nativeQuery = true)
        List<Criterio> obtenerCriteriosUltimoModelo();

        // SELECT c.*
        // FROM public.criterio c join public.subcriterio s ON s.id_criterio =
        // c.id_criterio join public.indicador i ON i.subcriterio_id_subcriterio =
        // s.id_subcriterio
        // WHERE i.id_indicador=1;
        @Query(value = "SELECT c.* FROM public.criterio c join public.subcriterio s ON s.id_criterio = c.id_criterio join public.indicador i ON i.subcriterio_id_subcriterio = s.id_subcriterio WHERE i.id_indicador=:id_indicador", nativeQuery = true)
        List<Criterio> listarCriterioPorIndicador(Long id_indicador);

        //LISTAR CRITERIOS DE UN MODELO EN ESPECIFICO
        @Query(value = "SELECT c.id_criterio, c.nombre, c.descripcion, c.visible FROM asignacion_indicador ag\n"
                + "JOIN indicador i ON ag.indicador_id_indicador = i.id_indicador\n"
                + "JOIN subcriterio s ON s.id_subcriterio = i.subcriterio_id_subcriterio \n"
                + "JOIN criterio c ON c.id_criterio = s.id_criterio \n"
                + "WHERE ag.modelo_id_modelo = :modelo AND c.visible = true\n"
                + "GROUP BY c.id_criterio, c.nombre, c.descripcion, c.visible\n"
                + "ORDER BY c.nombre ASC;", nativeQuery = true)
        List<Criterio> obtenerCriteriosPertenecientesAModelo(@Param("modelo") Long modelo);

        //CONSULTA PARA TRAER EL MODELO CON LOS CAMPOS DE CRITERIO, SUBCRITERIO, INDICADORES
        @Query(value = "SELECT " +
                "m.id_modelo, m.nombre AS nombre_modelo, m.fecha_inicio, m.fecha_fin, m.fecha_final_act," +
                "c.id_criterio, c.nombre AS nombre_criterio, c.descripcion AS descripcion_criterio, " +
                "sc.id_subcriterio, sc.nombre AS nombre_subcriterio, sc.descripcion AS descripcion_subcriterio, " +
                "i.id_indicador, i.nombre AS nombre_indicador, i.descripcion AS descripcion_indicador, i.peso, i.estandar, " +
                "i.valor_obtenido, i.porc_obtenido, i.porc_utilida_obtenida, i.tipo " +
                "FROM modelo m " +
                "JOIN criterio c ON m.id_modelo = :modelo " +
                "JOIN subcriterio sc ON c.id_criterio = sc.id_criterio " +
                "JOIN indicador i ON sc.id_subcriterio = i.subcriterio_id_subcriterio " +
                "JOIN asignacion_indicador ag ON i.id_indicador = ag.indicador_id_indicador " +
                "WHERE ag.modelo_id_modelo = :modelo AND c.visible = true " +
                "ORDER BY c.nombre ASC, sc.nombre ASC, i.nombre ASC", nativeQuery = true)
        List<Object[]> obtenerCSIConModelo(@Param("modelo") Long modelo);


}
