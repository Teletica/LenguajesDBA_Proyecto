/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.domain.Ventas;
import java.util.List;

public interface VentasService {
    public List<Ventas> getVentas(boolean activos);
    
    public Ventas getVentas(Ventas ventas);
    
    public void save(Ventas ventas);
    
    public void delete(Ventas ventas);
}
