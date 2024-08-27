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
@Table(name="Compras")
public class Compras implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Compra_Numero_Factura")
    private Long compraNumeroFactura;
    
    @Temporal(TemporalType.DATE)
    @Column(name="Fecha_Compra")
    private Date fechaCompra;
    
    @ManyToOne
    @JoinColumn(name = "Proveedor_ID")
    private Proveedores proveedor;

    @OneToMany(mappedBy = "compra")
    private List<DetalleCompra> detalleCompras;

    public Compras() {
    }
}
