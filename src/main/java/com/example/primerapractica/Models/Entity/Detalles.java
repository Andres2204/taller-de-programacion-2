package com.example.primerapractica.Models.Entity;



public class Detalles {

    private long id;
    private long idEncabezado;
    private long idProducto;
    private int cantidad;
    private double valor;
    private double descuento;

    public Detalles() {
    }


    public Detalles(long id, long idEncabezado, long idProducto, int cantidad, double valor, double descuento) {
        this.id = id;
        this.idEncabezado = idEncabezado;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.valor = valor;
        this.descuento = descuento;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getIdEncabezado() {
        return idEncabezado;
    }
    public void setIdEncabezado(long idEncabezado) {
        this.idEncabezado = idEncabezado;
    }
    public long getIdProducto() {
        return idProducto;
    }
    public void setIdProducto(long idProducto) {
        this.idProducto = idProducto;
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
