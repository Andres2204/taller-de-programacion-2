package com.example.primerapractica.Models.DAO;

import java.util.List;
import com.example.primerapractica.Models.Entity.Detalle;

public interface DetalleDao {

 public List<Detalle> findAll();

    public void Save(Detalle detalle);

    public Detalle findOne (Long id);

    public void Delete(Long id);
    


}
