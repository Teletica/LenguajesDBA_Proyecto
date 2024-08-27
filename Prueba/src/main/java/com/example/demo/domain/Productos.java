package com.example.demo.domain;

import java.io.Serializable;
import java.util.List;
import lombok.Data;
import jakarta.persistence.*;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
@Table(name="Productos")
public class Productos implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Producto_ID")
    private Long productoId;
    
    private String nombre;
    
    @Column(name="Precio_Venta")
    private double precioVenta;
    
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="Fecha_Caducidad")
    private Date fechaCaducidad;
    
    @ManyToOne
    @JoinColumn(name = "Proveedor_ID")
    private Proveedores proveedor;
    
    @OneToOne(mappedBy = "producto")
    private Inventarios inventario;
    
    @ManyToOne
    @JoinColumn(name = "Categoria_ID")
    private Categorias categoria;

    @OneToMany(mappedBy = "producto")
    private List<DetalleVenta> detalleVentas;

    @OneToMany(mappedBy = "producto")
    private List<DetalleCompra> detalleCompras;


    public Productos() {
    }
}

