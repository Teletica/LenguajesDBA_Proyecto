/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service.impl;

import com.example.demo.dao.CategoriasDao;
import com.example.demo.domain.Categorias;
import com.example.demo.service.CategoriasService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriasServiceImpl implements CategoriasService {

    @Autowired
    private CategoriasDao categoriasDao;

    @Override
    @Transactional(readOnly = true)
    public List<Categorias> getCategorias(boolean activos) {
        return categoriasDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Categorias getCategorias(Categorias categorias) {
        return categoriasDao.findById(categorias.getCategoriaId()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Categorias categorias) {
        categoriasDao.save(categorias);
    }

    @Override
    @Transactional
    public void delete(Categorias categorias) {
        categoriasDao.delete(categorias);
    }
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert( int T_CATEGORIA_ID, String T_NOMBRE, String T_DESCRIPCION) {                  
        jdbcTemplate.update("CALL INSERTAR_CATEGORIA(?, ?, ?)", T_CATEGORIA_ID, T_NOMBRE, T_DESCRIPCION);
    }
    
    public void detel( int T_CATEGORIA_ID) {                  
        jdbcTemplate.update("CALL ELIMINAR_CATEGORIA(?)", T_CATEGORIA_ID);
    }
    
    public void update( int T_CATEGORIA_ID, String T_NOMBRE, String T_DESCRIPCION) {                  
        jdbcTemplate.update("CALL MODIFICAR_CATEGORIA(?, ?, ?)", T_CATEGORIA_ID, T_NOMBRE, T_DESCRIPCION);
    }

}
