package com.example.primerapractica.Models.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.primerapractica.Models.Entity.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ClienteDaoImp implements IClienteDao {

    @PersistenceContext
    private EntityManager em;
     
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Cliente> findAll() {
        return em.createQuery("from Cliente").getResultList();
    }

    @Transactional
    @Override
    public void Save(Cliente cliente) {
   
        System.out.println(cliente.toString());

        // actualiza
        if(cliente.getId() != null && cliente.getId()>0){

            System.out.println("\n\n\n ENCONTRADO - ACTUALIZAR \n\n\n");
           
            em.merge(cliente);
        }
        else{ // crear nuevo

            System.out.println("\n\n\n no encontrad - Crear \n\n\n");
           
            em.merge(cliente);
           //em.persist(cliente);
        }

    }
    


    @Transactional(readOnly = true)
    @Override
    public Cliente findOne(Long id) {
        return em.find(Cliente.class, id);
    }

    @Transactional(readOnly = true)
    @Override
    public Cliente findByEmail(String email) {
        try {
            return (Cliente) em.createNativeQuery("SELECT * FROM clientes WHERE email = :email", Cliente.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (Exception e) {
            return null; // Si no se encuentra, se retorna null
        }
    }

    @Transactional
    @Override
    public void Delete(Long id) {
        Cliente cliente = findOne(id);
        em.remove(cliente);
    }

}
