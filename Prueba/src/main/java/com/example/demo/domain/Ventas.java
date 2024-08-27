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
@Table(name="Ventas")
public class Ventas implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Venta_Numero_Factura")
    private Long ventaNumeroFactura;
    
    @Temporal(TemporalType.DATE)
    @Column(name="Fecha_Venta")
    private Date fechaVenta;
    
    @ManyToOne
    @JoinColumn(name = "Cliente_ID")
    private Clientes cliente;
    
    @ManyToOne
    @JoinColumn(name = "Gerente_ID")
    private Trabajadores gerente;
    
    private double descuento;

    @OneToMany(mappedBy = "venta")
    private List<DetalleVenta> detalleVentas;

    public Ventas() {
    }
}
