/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.domain.Cargo;
import java.util.List;

public interface CargoService {
    public List<Cargo> getCargos(boolean activos);
    
    public Cargo getCargo(Cargo cargo);
    
    public void save(Cargo cargo);
    
    public void delete(Cargo cargo);
    
    
    
    
    public void insert( int T_CARGO_ID, String T_DESCRIPCION);
    
    public void detel( int T_CARGO_ID);
    
    public void update( int T_CARGO_ID, String T_DESCRIPCION);
}
