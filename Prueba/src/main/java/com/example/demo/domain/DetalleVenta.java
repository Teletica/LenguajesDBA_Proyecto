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
@Table(name="Detalle_Venta")
public class DetalleVenta implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="Venta_Numero_Factura")
    private Long ventaNumeroFactura;
    
    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "Venta_Numero_Factura", insertable = false, updatable = false)
    private Ventas venta;
    
    @ManyToOne
    @JoinColumn(name = "Producto_ID", insertable = false, updatable = false)
    private Productos producto;

    public DetalleVenta() {
    }
}
