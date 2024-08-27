/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.domain.Trabajadores;
import java.util.List;

public interface TrabajadoresService {
    public List<Trabajadores> getTrabajadores(boolean activos);
    
    public Trabajadores getTrabajadores(Trabajadores trabajadores);
    
    public void save(Trabajadores trabajadores);
    
    public void delete(Trabajadores trabajadores);
    
    
    
    public void insert( String T_CEDULA, String T_NOMBRE, String T_APELLIDO, String T_EMAIL, String T_TELEFONO, String T_TURNO, int T_CARGO_ID, int T_GAFETES_DE_ID);
    

    public void detel( String T_CEDULA);
    

    public void update( String T_CEDULA, String T_NOMBRE, String T_APELLIDO, String T_EMAIL, String T_TELEFONO, String T_TURNO, int T_CARGO_ID, int T_GAFETES_DE_ID);

    public String getTrabajadoresFiltradosPorNombre(String nombre);
}
