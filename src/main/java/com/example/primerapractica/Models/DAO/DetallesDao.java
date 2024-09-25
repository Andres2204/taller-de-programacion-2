package com.example.primerapractica.Models.DAO;

import java.util.List;

import com.example.primerapractica.Models.Entity.Detalles;


public interface DetallesDao{
 public List<Detalles> findAll();

    public void Save(Detalles detalles);

    public Detalles findOne (Long id);

    public void Delete(Long id);
    


}
