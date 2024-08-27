/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service.impl;

import com.example.demo.dao.VentasDao;
import com.example.demo.domain.Ventas;
import com.example.demo.service.VentasService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VentasServiceImpl implements VentasService {

    @Autowired
    private VentasDao ventasDao;

    @Override
    @Transactional(readOnly = true)
    public List<Ventas> getVentas(boolean activos) {
        return ventasDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Ventas getVentas(Ventas ventas) {
        return ventasDao.findById(ventas.getVentaNumeroFactura()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Ventas ventas) {
        ventasDao.save(ventas);
    }

    @Override
    @Transactional
    public void delete(Ventas ventas) {
        ventasDao.delete(ventas);
    }
}
