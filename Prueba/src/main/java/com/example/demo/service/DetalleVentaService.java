/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.domain.DetalleVenta;
import java.util.List;

public interface DetalleVentaService {
    public List<DetalleVenta> getDetalleVentas(boolean activos);
    
    public DetalleVenta getDetalleVenta(DetalleVenta detalleVenta);
    
    public void save(DetalleVenta detalleVenta);
    
    public void delete(DetalleVenta detalleVenta);
}
