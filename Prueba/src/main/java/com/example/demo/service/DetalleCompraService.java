/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.domain.DetalleCompra;
import java.util.List;

public interface DetalleCompraService {
    public List<DetalleCompra> getDetalleCompras(boolean activos);
    
    public DetalleCompra getDetalleCompra(DetalleCompra detalleCompra);
    
    public void save(DetalleCompra detalleCompra);
    
    public void delete(DetalleCompra detalleCompra);
}
