package com.example.primerapractica.Models.Entity;

import java.sql.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
@Table(name="encabezado")
@EntityListeners(AuditingEntityListener.class)
public class Encabezado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private Cliente cliente;

    @CreatedDate
    @Column(name = "fecha_creacion", updatable = false)
    private Date fecha;

    @NotNull(message = "{NotEmpty.encabezado.subtotal}") 
    @Positive(message = "{Positive.encabezado.subtotal}") 
    private double subtotal;

    @NotNull(message = "{NotEmpty.encabezado.subtotal}") 
    @Positive(message = "{Positive.encabezado.total}") 
    private double total;

    @NotNull(message = "{NotEmpty.encabezado.subtotal}") 
    @PositiveOrZero(message = "{PositiveOrZero.encabezado.descuentoTotal}") 
    private double descuentoTotal;

    public Encabezado() {
    }

    public Encabezado(long id, Cliente cliente, Date fecha, double subtotal, double total, double descuentoTotal) {
        this.id = id;
        this.cliente = cliente;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
