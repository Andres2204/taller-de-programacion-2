package com.example.primerapractica.Models.DAO;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.example.primerapractica.Models.Entity.Encabezado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class EncabezadoDaoImp implements EncabezadoDAO {

 @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Encabezado> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Transactional
    @Override
    public void Save(Encabezado encabezado) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Save'");
    }

    @Transactional(readOnly = true)
    @Override
    public Encabezado findOne(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findOne'");
    }

       @Transactional
    @Override
    public void Delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Delete'");
    }
    
}
