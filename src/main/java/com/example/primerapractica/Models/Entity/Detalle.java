package com.example.primerapractica.Models.Entity;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
@Table(name="detalles")
public class Detalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @ManyToOne
    private Encabezado encabezado;
    
    @OneToOne
    private Producto producto;

    @NotNull(message = "{NotEmpty.Detalle.cantidad}") 
    @PositiveOrZero(message = "{PositiveOrZero.Detalle.cantidad}")
    private int cantidad;
    
    @NotNull(message = "{NotEmpty.Detalle.valor}") 
    @Positive(message = "{Positive.Detalle.valor}") 
    private double valor;
    
    @NotNull(message = "{NotEmpty.Detalle.descuento}") 
    @PositiveOrZero(message = "{PositiveOrZero.Detalle.descuento}")
    private double descuento;

    public Detalle() {
    }

    public Detalle(long id, Encabezado encabezado, Producto producto, int cantidad, double valor, double descuento) {
        this.id = id;
        this.encabezado = encabezado;
        this.producto = producto;
        this.cantidad = cantidad;
        this.valor = valor;
        this.descuento = descuento;
    }

    public Encabezado getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(Encabezado encabezado) {
        this.encabezado = encabezado;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

}
