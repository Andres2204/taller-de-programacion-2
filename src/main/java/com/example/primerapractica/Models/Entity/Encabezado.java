package com.example.primerapractica.Models.Entity;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import java.io.Serializable;

@Entity
@Table(name = "encabezado")
public class Encabezado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    @NotNull // valida que la fecha no sea nula
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @NotNull(message = "{NotEmpty.encabezado.subtotal}")
    @Positive(message = "{Positive.encabezado.subtotal}")
    private double subtotal;

    @NotNull(message = "{NotEmpty.encabezado.subtotal}")
    @Positive(message = "{Positive.encabezado.total}")
    private double total;

    @NotNull(message = "{NotEmpty.encabezado.descuentoTotal}")
    @PositiveOrZero(message = "{PositiveOrZero.encabezado.descuentoTotal}")
    private double descuentoTotal;

    public Encabezado() {
        perPersist();
    }


    @PrePersist
    private void perPersist() {
        fecha = new Date();
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


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

}
