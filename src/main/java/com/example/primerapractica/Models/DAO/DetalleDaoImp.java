package com.example.primerapractica.Models.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.primerapractica.Models.Entity.Detalle;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class DetalleDaoImp implements DetalleDao {

     @PersistenceContext
    private EntityManager em;

    
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Detalle> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Transactional
    @Override
    public void Save(Detalle detalle) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Save'");
    }

    @Transactional(readOnly = true)
    @Override
    public Detalle findOne(Long id) {
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

