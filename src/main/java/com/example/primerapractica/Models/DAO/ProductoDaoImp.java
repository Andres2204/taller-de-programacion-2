package com.example.primerapractica.Models.DAO;

import com.example.primerapractica.Models.Entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductoDaoImp implements IProductoDao {
    @Override
    public List<Producto> findAll() {
        return null;
    }

    @Override
    public void Save(Producto producto) {

    }

    @Override
    public Producto findOne(Long id) {
        return null;
    }

    @Override
    public void Delete(Long id) {

    }
}
