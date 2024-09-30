package com.example.primerapractica.Models.DAO;

import java.util.List;

import com.example.primerapractica.Models.Entity.Detalle;

public interface IDetalleDao {

    public List<Detalle> findAll();

    public List<Detalle> findAll(Long id);

    public void save(Detalle detalle);

    public Detalle findOne(Long id);

    public void delete(Long id);


}
