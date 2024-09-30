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
        return em.createQuery("from Detalle").getResultList();
    }

    @Transactional
    @Override
    public void save(Detalle detalle) {
        System.out.println(detalle.toString());

        // actualiza
        if(detalle.getId() != null && detalle.getId()>0){

            System.out.println("\n\n\n ENCONTRADO - ACTUALIZAR \n\n\n");
            em.merge(detalle);
        }
        else{ // crear nuevo

            System.out.println("\n\n\n no encontrad - Crear \n\n\n");
            
            em.merge(detalle);
          
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Detalle findOne(Long id) {
         return em.find(Detalle.class, id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Detalle detalle=findOne(id);
        em.remove(detalle);
    }
    
}

