package com.example.primerapractica.Models.Entity;

import java.sql.Date;

public class Encabezado {

    private long id;
    private long idCliente;
    private Date fecha;
    private double subtotal;
    private double total;
    private double descuentoTotal;


    public Encabezado() {
    }
    
    public Encabezado(long id, long idCliente, Date fecha, double subtotal, double total, double descuentoTotal) {
        this.id = id;
        this.idCliente = idCliente;
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.total = total;
        this.descuentoTotal = descuentoTotal;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public double getSubtotal() {
        return subtotal;
    }
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }
    public double getDescuentoTotal() {
        return descuentoTotal;
    }
    public void setDescuentoTotal(double descuentoTotal) {
        this.descuentoTotal = descuentoTotal;
    }

    
    
}
