/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.domain.Proveedores;
import java.util.List;

public interface ProveedoresService {
    public List<Proveedores> getProveedores(boolean activos);
    
    public Proveedores getProveedores(Proveedores proveedores);
    
    public void save(Proveedores proveedores);
    
    public void delete(Proveedores proveedores);
    
    public void insertProveedor(int T_PROVEEDOR_ID, String T_NOMBRE, String T_TELEFONO, String T_EMAIL);
    
    public void deteleProveedor( int T_PROVEEDOR_ID);
    
    public void updateProveedor( int T_PROVEEDOR_ID, String T_NOMBRE, String T_TELEFONO, String T_EMAIL);
}
