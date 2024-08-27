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
@Table(name="Informes_de_Venta")
public class InformesDeVenta implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Informe_ID")
    private Long informeId;

    private String descripcion;
    
    @ManyToOne
    @JoinColumn(name = "Empresa_ID")
    private EmpresaEncargada empresaEncargada;

    @ManyToOne
    @JoinColumn(name = "Numero_Factura", insertable = false, updatable = false)
    private Ventas ventas;

    public InformesDeVenta() {
    }
}
