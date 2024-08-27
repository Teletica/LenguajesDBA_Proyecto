/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.domain.Productos;
import java.util.Date;
import java.util.List;

/**
 *
 * @author gabriel badilla
 */
public interface ProductosService {
    public List<Productos> getProductos(boolean activos);
    
    public Productos getProductos(Productos productos);
    
    public void save(Productos productos);
    
    public void delete(Productos productos);
    
    public String getProductosFiltradosPorNombre(String nombre);  
    
    public void insert( int T_PRODUCTO_ID, String  T_NOMBRE, int  T_PRECIO_VENTA, Date T_FECHA_CADUCIDAD, int T_PROVEEDOR_ID, int T_CATEGORIA_ID);
    
    public void detel( int T_PRODUCTO_ID);

    public void update( int T_PRODUCTO_ID, String  T_NOMBRE, double  T_PRECIO_VENTA, Date T_FECHA_CADUCIDAD, int T_PROVEEDOR_ID, int T_CATEGORIA_ID);

}
