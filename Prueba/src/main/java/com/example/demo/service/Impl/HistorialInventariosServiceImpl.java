/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service.impl;

import com.example.demo.dao.HistorialInventariosDao;
import com.example.demo.domain.HistorialInventarios;
import com.example.demo.service.HistorialInventariosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HistorialInventariosServiceImpl implements HistorialInventariosService {

    @Autowired
    private HistorialInventariosDao historialInventariosDao;

    @Override
    @Transactional(readOnly = true)
    public List<HistorialInventarios> getHistorialInventarios(boolean activos) {
        return historialInventariosDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public HistorialInventarios getHistorialInventarios(HistorialInventarios historialInventarios) {
        return historialInventariosDao.findById(historialInventarios.getHistorialId()).orElse(null);
    }

    @Override
    @Transactional
    public void save(HistorialInventarios historialInventarios) {
        historialInventariosDao.save(historialInventarios);
    }

    @Override
    @Transactional
    public void delete(HistorialInventarios historialInventarios) {
        historialInventariosDao.delete(historialInventarios);
    }
}
