/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service.impl;

import com.example.demo.dao.InventariosDao;
import com.example.demo.domain.Inventarios;
import com.example.demo.service.InventariosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InventariosServiceImpl implements InventariosService {

    @Autowired
    private InventariosDao inventariosDao;

    @Override
    @Transactional(readOnly = true)
    public List<Inventarios> getInventarios(boolean activos) {
        return inventariosDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Inventarios getInventarios(Inventarios inventarios) {
        return inventariosDao.findById(inventarios.getProducto()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Inventarios inventarios) {
        inventariosDao.save(inventarios);
    }

    @Override
    @Transactional
    public void delete(Inventarios inventarios) {
        inventariosDao.delete(inventarios);
    }
    
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert( int PRODUCTO_ID, int CANTIDAD_STOCK) {                  
        jdbcTemplate.update("CALL INSERTAR_INVENTARIO(?, ?)", PRODUCTO_ID, CANTIDAD_STOCK);
    }
    

    public void detel( int PRODUCTO_ID) {                  
        jdbcTemplate.update("CALL ELIMINAR_INVENTARIO(?)", PRODUCTO_ID);
    }
    

    public void update( int PRODUCTO_ID, int CANTIDAD_STOCK) {                  
        jdbcTemplate.update("CALL MODIFICAR_INVENTARIO(?, ?)", PRODUCTO_ID, CANTIDAD_STOCK);
    }

    
}
