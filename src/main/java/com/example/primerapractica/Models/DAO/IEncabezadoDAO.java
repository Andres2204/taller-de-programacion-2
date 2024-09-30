package com.example.primerapractica.Models.DAO;

import java.util.List;

import com.example.primerapractica.Models.Entity.Encabezado;

public interface IEncabezadoDAO {

    public List<Encabezado> findAll();

    public void Save(Encabezado encabezado);

    public Encabezado findOne (Long id);

    public void Delete(Long id);
    
    
}
