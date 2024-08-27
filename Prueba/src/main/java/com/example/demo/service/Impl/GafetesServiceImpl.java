/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service.impl;

import com.example.demo.dao.GafetesDao;
import com.example.demo.domain.Gafetes;
import com.example.demo.service.GafetesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GafetesServiceImpl implements GafetesService {

    @Autowired
    private GafetesDao gafetesDao;

    @Override
    @Transactional(readOnly = true)
    public List<Gafetes> getGafetes(boolean activos) {
        return gafetesDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Gafetes getGafetes(Gafetes gafetes) {
        return gafetesDao.findById(gafetes.getGafetesDeId()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Gafetes gafetes) {
        gafetesDao.save(gafetes);
    }

    @Override
    @Transactional
    public void delete(Gafetes gafetes) {
        gafetesDao.delete(gafetes);
    }
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert( int T_GAFETES_ID, String T_DESCRIPCION) {                  
        jdbcTemplate.update("CALL INSERTAR_GAFETE(?, ?)", T_GAFETES_ID, T_DESCRIPCION);
    }
    
    public void detel( int T_GAFETES_ID) {                  
        jdbcTemplate.update("CALL ELIMINAR_GAFETE(?)", T_GAFETES_ID);
    }
    
    public void update( int T_GAFETES_ID, String T_DESCRIPCION) {                  
        jdbcTemplate.update("CALL MODIFICAR_GAFETE(?, ?)", T_GAFETES_ID, T_DESCRIPCION);
    }
    
}
