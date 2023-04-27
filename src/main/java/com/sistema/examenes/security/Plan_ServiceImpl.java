package com.sistema.examenes.security;

import com.sistema.examenes.entity.Criterio;
import com.sistema.examenes.entity.Plan;
import com.sistema.examenes.repository.Criterio_repository;
import com.sistema.examenes.repository.Plan_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class Plan_ServiceImpl extends GenericServiceImpl<Plan, Long> implements Plan_Service {
    @Autowired
    private Plan_repository repository;
    @Override
    public CrudRepository<Plan, Long > getDao() {

        return repository;
    }


}
