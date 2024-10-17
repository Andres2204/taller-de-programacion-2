package com.example.primerapractica.Models.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.io.Serializable;

@Entity
@Table(name = "carrito")
public class Carrito implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdCarrito;

    @OneToOne
    private Cliente cliente;

    @ManyToOne
    private Producto producto;

    @NotNull()
    @Positive()
    private int valorTotal;

    public Carrito() {
    }

    public Long getIdCarrito() {
        return IdCarrito;
    }

    public void setIdCarrito(Long idCarrito) {
        IdCarrito = idCarrito;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @NotNull()
    @Positive()
    public int getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(@NotNull() @Positive() int valorTotal) {
        this.valorTotal = valorTotal;
    }
}
