/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service.impl;

import com.example.demo.dao.ProveedoresDao;
import com.example.demo.domain.Proveedores;
import com.example.demo.service.ProveedoresService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProveedoresServiceImpl implements ProveedoresService {

    @Autowired
    private ProveedoresDao proveedoresDao;

    @Override
    @Transactional(readOnly = true)
    public List<Proveedores> getProveedores(boolean activos) {
        return proveedoresDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Proveedores getProveedores(Proveedores proveedores) {
        return proveedoresDao.findById(proveedores.getProveedorId()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Proveedores proveedores) {
        proveedoresDao.save(proveedores);
    }

    @Override
    @Transactional
    public void delete(Proveedores proveedores) {
        proveedoresDao.delete(proveedores);
    }
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertProveedor( int T_PROVEEDOR_ID, String T_NOMBRE, String T_TELEFONO, String T_EMAIL) {                  
        jdbcTemplate.update("CALL INSERTAR_PROVEEDOR(?, ?, ?, ?)", T_PROVEEDOR_ID, T_NOMBRE, T_TELEFONO, T_EMAIL);
    }
    
    public void deteleProveedor( int T_PROVEEDOR_ID) {                  
        jdbcTemplate.update("CALL ELIMINAR_PROVEEDOR(?)", T_PROVEEDOR_ID);
    }
    
    public void updateProveedor( int T_PROVEEDOR_ID, String T_NOMBRE, String T_TELEFONO, String T_EMAIL) {                  
        jdbcTemplate.update("CALL MODIFICAR_PROVEEDOR(?, ?, ?, ?)", T_PROVEEDOR_ID, T_NOMBRE, T_TELEFONO, T_EMAIL);
    }
}

