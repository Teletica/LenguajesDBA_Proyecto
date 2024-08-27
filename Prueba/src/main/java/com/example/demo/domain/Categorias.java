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
@Table(name="Categorias")
public class Categorias implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Categoria_ID")
    private Long categoriaId;
    
    private String nombre;
    private String descripcion;

    @OneToMany(mappedBy = "categoria")
    private List<Productos> productos;

    public Categorias() {
    }
}
