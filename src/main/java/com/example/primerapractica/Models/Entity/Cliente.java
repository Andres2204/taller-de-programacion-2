package com.example.primerapractica.Models.Entity;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.UniqueElements;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long Id;

    @NotEmpty(message = "{NotEmpty.cliente.Nombre}") // que es requerido u obligatorio
    public String Nombre;

    @NotEmpty(message = "{NotEmpty.cliente.Apellido}")
    @Size(min = 4, max = 15, message = "{Size.cliente.Apellido}")
    public String Apellido;

    @NotEmpty(message = "{NotEmpty.cliente.Email}")
    @Email(message = "{Email.cliente.Email}")
    @Column(unique = true)
    public String Email;

    @NotEmpty(message = "{password.cliente.password}")
    public String password;

    @NotNull // valida que la fecha no sea nula
    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    public Date CreateAt;

    public Cliente(String s) {
        Nombre = "nombre";
        Apellido = "apellido";
        perPersist();
    }

    public Cliente() {
        perPersist();
    }

    @PrePersist
    private void perPersist() {
        CreateAt = new Date();
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "Id=" + Id +
                ", Nombre='" + Nombre + '\'' +
                ", Apellido='" + Apellido + '\'' +
                ", Email='" + Email + '\'' +
                ", CreateAt=" + CreateAt +
                '}';
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateAt() {
        return CreateAt;
    }

    public void setCreateAt(Date createAt) {
        CreateAt = createAt;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    private static final long serialVersionUID = 1L;

}
