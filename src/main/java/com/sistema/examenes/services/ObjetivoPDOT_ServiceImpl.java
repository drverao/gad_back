package com.sistema.examenes.services;

import com.sistema.examenes.entity.EjePND;
import com.sistema.examenes.entity.ObjetivoPDOT;
import com.sistema.examenes.repository.EjePNDRepository;
import com.sistema.examenes.repository.ObjetivoPDOTRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjetivoPDOT_ServiceImpl extends GenericServiceImpl<ObjetivoPDOT, Long> implements ObjetivoPDOT_Service {

    @Autowired
    private ObjetivoPDOTRepository repository;

    @Override
    public CrudRepository<ObjetivoPDOT, Long> getDao() {
        return repository;
    }

    @Override
    public List<ObjetivoPDOT> listar() {
        return repository.listarObjetivosPdots();
    }
}
