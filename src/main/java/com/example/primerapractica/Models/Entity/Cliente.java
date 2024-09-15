package com.example.primerapractica.Models.Entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="clientes")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotEmpty //que es requerido u obligatorio
    private String Nombre;

    @NotEmpty
    @Size(min=4, max=15)
    private String Apellido;

    @NotEmpty
    @Email
    private String Email;

    @NotNull //valida que la fecha no sea nula
    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date CreateAt;

    @PrePersist
    public void perPersist(){

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
