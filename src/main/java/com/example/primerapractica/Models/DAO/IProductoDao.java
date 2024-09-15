package com.example.primerapractica.Models.DAO;

import com.example.primerapractica.Models.Entity.Producto;
import java.util.List;

public interface IProductoDao {

    public List<Producto> findAll();

    public void Save(Producto producto);

    public Producto findOne (Long id);

    public void Delete(Long id);
}
