package com.sistema.examenes.services;

import com.sistema.examenes.entity.Asignacion_Admin;
import com.sistema.examenes.entity.Asignacion_Admin;
import com.sistema.examenes.repository.Asignacion_Admin_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Asignacion_Admin_ServiceImpl extends GenericServiceImpl<Asignacion_Admin, Long> implements Asignacion_Admin_Service {
    @Autowired
    private Asignacion_Admin_repository repository;
    @Override
    public CrudRepository<Asignacion_Admin, Long > getDao() {
        return repository;
    }
    @Override
    public List<Asignacion_Admin> listar() {
        return repository.listarAsignacion_Admin();
    }

}
