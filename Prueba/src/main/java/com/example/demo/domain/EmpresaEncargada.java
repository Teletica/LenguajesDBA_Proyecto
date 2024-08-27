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
@Table(name="Empresa_Encargada")
public class EmpresaEncargada implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Empresa_ID")
    private Long empresaId;
    
    private String nombre;
    private String ubicacion;
    private String telefono;

    @OneToMany(mappedBy = "empresaEncargada")
    private List<InformesDeVenta> informesDeVenta;

    public EmpresaEncargada() {
    }
}
