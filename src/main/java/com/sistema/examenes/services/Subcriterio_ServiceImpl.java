package com.sistema.examenes.services;

import com.sistema.examenes.entity.Subcriterio;
import com.sistema.examenes.repository.Subcriterio_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class Subcriterio_ServiceImpl extends GenericServiceImpl<Subcriterio, Long> implements Subcriterio_Service {
    @Autowired
    private Subcriterio_repository repository;
    @Override
    public CrudRepository<Subcriterio, Long > getDao() {

        return repository;
    }


}
