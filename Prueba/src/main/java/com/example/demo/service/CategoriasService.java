/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.domain.Categorias;
import java.util.List;

public interface CategoriasService {
    public List<Categorias> getCategorias(boolean activos);
    
    public Categorias getCategorias(Categorias categorias);
    
    public void save(Categorias categorias);
    
    public void delete(Categorias categorias);
    
    
    
    
    
    public void insert(int T_CATEGORIA_ID, String T_NOMBRE, String T_DESCRIPCION);
    
    public void detel( int T_CATEGORIA_ID);
    
    public void update( int T_CATEGORIA_ID, String T_NOMBRE, String T_DESCRIPCION);

}
