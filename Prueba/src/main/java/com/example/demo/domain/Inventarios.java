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
@Table(name="inventarios")
public class Inventarios implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Producto_ID")
    private Long productoID;

    @OneToOne
    @JoinColumn(name = "Producto_ID", referencedColumnName = "Producto_ID")
    private Productos producto;
    
    @Column(name="Cantidad_Stock")
    private int cantidadStock;

    public Inventarios() {
    }
}
