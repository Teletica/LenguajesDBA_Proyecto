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
@Table(name="Proveedores")
public class Proveedores implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Proveedor_ID")
    private Long proveedorId;
    
    private String nombre;
    private String telefono;
    private String email;

    @OneToMany(mappedBy = "proveedor")
    private List<Productos> productos;

    @OneToMany(mappedBy = "proveedor")
    private List<Compras> compras;

    public Proveedores() {
    }
}

