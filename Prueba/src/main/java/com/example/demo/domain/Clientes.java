/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.domain;

import java.io.Serializable;
import java.util.List;
import lombok.Data;
import jakarta.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="Clientes")
public class Clientes implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="Cliente_ID")
    private Long clienteId;
    
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String direccion;
    
    @Temporal(TemporalType.DATE)
    @Column(name="Fecha_Registro", nullable = false, updatable = false)
    private Date fechaRegistro;

    @OneToMany(mappedBy = "cliente")
    private List<Ventas> ventas;

    public Clientes() {
        this.fechaRegistro = new Date();
    }
}


