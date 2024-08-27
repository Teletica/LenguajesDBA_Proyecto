/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.domain.HistorialInventarios;
import java.util.List;

public interface HistorialInventariosService {
    public List<HistorialInventarios> getHistorialInventarios(boolean activos);
    
    public HistorialInventarios getHistorialInventarios(HistorialInventarios historialInventarios);
    
    public void save(HistorialInventarios historialInventarios);
    
    public void delete(HistorialInventarios historialInventarios);
}
