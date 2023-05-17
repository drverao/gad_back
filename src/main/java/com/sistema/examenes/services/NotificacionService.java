package com.sistema.examenes.services;

import com.sistema.examenes.entity.Notificacion;

import java.util.List;

public interface NotificacionService extends GenericService<Notificacion, Long> {
    public List<Notificacion> listar(Long user);
    public void eliminar(Long id);
    public List<Notificacion> listarNotifi(String fecha);
    public List<Notificacion> all(String roluser);
}
