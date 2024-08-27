/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.domain;


import java.io.Serializable;
import java.util.List;
import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name="Cargo")
public class Cargo implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Cargo_ID")
    private Long cargoId;
    
    private String descripcion;

    @OneToMany(mappedBy = "cargo")
    private List<Trabajadores> trabajadores;

    public Cargo() {
    }
}
