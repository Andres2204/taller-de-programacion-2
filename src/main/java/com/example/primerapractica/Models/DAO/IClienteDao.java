package com.example.primerapractica.Models.DAO;

import java.util.List;

import com.example.primerapractica.Models.Entity.Cliente;

public interface IClienteDao {

    public List<Cliente> findAll();

    public void Save(Cliente cliente);

    public Cliente findOne (Long id);
    
    public void Delete(Long id);
}
