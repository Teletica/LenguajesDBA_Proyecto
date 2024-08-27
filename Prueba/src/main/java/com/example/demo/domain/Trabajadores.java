/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.domain;

import java.io.Serializable;
import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name="Trabajadores")
public class Trabajadores implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="Cedula")
    private String cedula;
    
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String turno;
    
    
    
    @ManyToOne
    @JoinColumn(name = "Cargo_ID")
    private Cargo cargo;

    @ManyToOne
    @JoinColumn(name = "Gafetes_de_ID")
    private Gafetes gafetes;

    public Trabajadores() {
    }
}