package com.example.primerapractica.Models.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.io.Serializable;

@Entity
@Table(name = "productos")
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @NotEmpty
    private String Nombre;
    @NotEmpty
    private String Descripcion;
    
    @NotEmpty
    @Positive
    private int ValorUnitario;
    @NotEmpty
    @PositiveOrZero
    private int Stock;

    public Producto() {
    }

    public Producto(long id, String nombre, String descripcion, int valorUnitario, int stock) {
        Id = id;
        Nombre = nombre;
        Descripcion = descripcion;
        ValorUnitario = valorUnitario;
        Stock = stock;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public int getValorUnitario() {
        return ValorUnitario;
    }

    public void setValorUnitario(int valorUnitario) {
        ValorUnitario = valorUnitario;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int stock) {
        Stock = stock;
    }
}
