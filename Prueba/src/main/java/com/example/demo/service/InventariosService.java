/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.domain.Inventarios;
import java.util.List;

public interface InventariosService {
    public List<Inventarios> getInventarios(boolean activos);
    
    public Inventarios getInventarios(Inventarios inventarios);
    
    public void save(Inventarios inventarios);
    
    public void delete(Inventarios inventarios);

    public void insert( int PRODUCTO_ID, int CANTIDAD_STOCK);
    

    public void detel( int PRODUCTO_ID);
   
    
    public void update( int PRODUCTO_ID, int CANTIDAD_STOCK);

}
