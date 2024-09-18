package com.example.primerapractica.Models.DAO;

import com.example.primerapractica.Models.Entity.Cliente;
import com.example.primerapractica.Models.Entity.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ProductoDaoImp implements IProductoDao {

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Producto> findAll() {
        return em.createQuery("from Producto").getResultList();
    }

    @Transactional
    @Override
    public void Save(Producto producto) {
        System.out.println(producto.toString());

        // actualiza
        if(producto.getId() != null && producto.getId()>0){

            System.out.println("\n\n\n ENCONTRADO - ACTUALIZAR \n\n\n");
            em.merge(producto);
        }
        else{ // crear nuevo

            System.out.println("\n\n\n no encontrad - Crear \n\n\n");
            
            em.merge(producto);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Producto findOne(Long id) {
         return em.find(Producto.class, id);
    }

    @Transactional
    @Override
    public void Delete(Long id) {
        Producto producto=findOne(id);
        em.remove(producto);
    }
}
