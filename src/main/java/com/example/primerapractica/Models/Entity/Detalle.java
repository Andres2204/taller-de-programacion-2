package com.example.primerapractica.Models.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import java.io.Serializable;

@Entity
@Table(name = "detalles")
public class Detalle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Encabezado encabezado;

    @ManyToOne
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
