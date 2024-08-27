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
@Table(name="Detalle_Compra")
public class DetalleCompra implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="Compra_Numero_Factura")
    private Long compraNumeroFactura;
   
    private int cantidad;
    
    @Column(name="Precio_Bruto")
    private double precioBruto;

    @ManyToOne
    @JoinColumn(name = "Compra_Numero_Factura", insertable = false, updatable = false)
    private Compras compra;
    
    @ManyToOne
    @JoinColumn(name = "Producto_ID", insertable = false, updatable = false)
    private Productos producto;

    public DetalleCompra() {
    }
}
