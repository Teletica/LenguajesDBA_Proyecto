/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.domain.InformesDeVenta;
import java.util.List;

public interface InformesDeVentaService {
    public List<InformesDeVenta> getInformesDeVenta(boolean activos);
    
    public InformesDeVenta getInformesDeVenta(InformesDeVenta informesDeVenta);
    
    public void save(InformesDeVenta informesDeVenta);
    
    public void delete(InformesDeVenta informesDeVenta);
}
