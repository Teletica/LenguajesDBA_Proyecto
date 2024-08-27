/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.domain.Clientes;
import java.util.List;

public interface ClientesService {
    public List<Clientes> getClientes(boolean activos);
    
    public Clientes getClientes(Clientes clientes);
    
    public void save(Clientes clientes);
    
    public void delete(Clientes clientes);
    
    
    
    public void insert(int T_CLIENTE_ID, String T_NOMBRE, String T_APELLIDO, String T_EMAIL, String T_TELEFONO, String T_DIRECCION);
    
    public void detel( int T_CLIENTE_ID);
    
    public void update( int T_CLIENTE_ID, String T_NOMBRE, String T_APELLIDO, String T_EMAIL, String T_TELEFONO, String T_DIRECCION);
    
    public String getClientesFiltradosPorNombre(String nombre);
}
