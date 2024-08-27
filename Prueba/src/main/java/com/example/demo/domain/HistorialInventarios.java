/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name="Historial_Inventarios")
public class HistorialInventarios implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Historial_ID")
    private Long historialId;
    
    @ManyToOne
    @JoinColumn(name = "Producto_ID")
    private Productos producto;
    
    @Temporal(TemporalType.DATE)
    @Column(name="Fecha_Movimiento")
    private Date fechaMovimiento;
    
    @Column(name="Cantidad_Movimiento")
    private int cantidadMovimiento;
    
    @Column(name="Tipo_Movimiento")
    private String tipoMovimiento;
    
    private String descripcion;

    public HistorialInventarios() {
    }
}
