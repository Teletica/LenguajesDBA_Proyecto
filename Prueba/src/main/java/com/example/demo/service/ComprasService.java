/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.domain.Compras;
import java.util.List;

public interface ComprasService {
    public List<Compras> getCompras(boolean activos);
    
    public Compras getCompras(Compras compras);
    
    public void save(Compras compras);
    
    public void delete(Compras compras);
}
