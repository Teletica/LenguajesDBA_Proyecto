/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service.Impl;

import com.example.demo.dao.CargoDao;
import com.example.demo.domain.Cargo;
import com.example.demo.service.CargoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CargoServiceImpl implements CargoService {

    @Autowired
    private CargoDao cargoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cargo> getCargos(boolean activos) {
        return cargoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cargo getCargo(Cargo cargo) {
        return cargoDao.findById(cargo.getCargoId()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Cargo cargo) {
        cargoDao.save(cargo);
    }

    @Override
    @Transactional
    public void delete(Cargo cargo) {
        cargoDao.delete(cargo);
    }
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert( int T_CARGO_ID, String T_DESCRIPCION) {                  
        jdbcTemplate.update("CALL INSERTAR_CARGO(?, ?)", T_CARGO_ID, T_DESCRIPCION);
    }
    
    public void detel( int T_CARGO_ID) {                  
        jdbcTemplate.update("CALL ELIMINAR_CARGO(?)", T_CARGO_ID);
    }
    
    public void update( int T_CARGO_ID, String T_DESCRIPCION) {                  
        jdbcTemplate.update("CALL MODIFICAR_CARGO(?, ?)", T_CARGO_ID, T_DESCRIPCION);
    }
}
