package com.example.primerapractica.Models.DAO;

import java.util.List;

import com.example.primerapractica.Models.Entity.Encabezado;
import org.springframework.stereotype.Repository;


public interface IEncabezadoDAO {

    public List<Encabezado> findAll();

    public void save(Encabezado encabezado);

    public Encabezado findOne (Long id);

    public void delete(Long id);
    
    
}
