package com.example.primerapractica.Models.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.primerapractica.Models.Entity.Encabezado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class EncabezadoDaoImp implements EncabezadoDAO {

 @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Encabezado> findAll() {
        return em.createQuery("from Encabezado").getResultList();
    }

    @Transactional
    @Override
    public void save(Encabezado encabezado) {
        System.out.println(encabezado.toString());

        // actualiza
        if(encabezado.getId() != null && encabezado.getId()>0){

            System.out.println("\n\n\n ENCONTRADO - ACTUALIZAR \n\n\n");
            em.merge(encabezado);
        }
        else{ // crear nuevo

            System.out.println("\n\n\n no encontrad - Crear \n\n\n");
            
            em.merge(encabezado);
           
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Encabezado findOne(Long id) {
       return em.find(Encabezado.class, id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Encabezado encabezado=findOne(id);
        em.remove(encabezado);
    }
    
}
