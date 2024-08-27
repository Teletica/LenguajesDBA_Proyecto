/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service.impl;

import com.example.demo.dao.DetalleVentaDao;
import com.example.demo.domain.DetalleVenta;
import com.example.demo.service.DetalleVentaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DetalleVentaServiceImpl implements DetalleVentaService {

    @Autowired
    private DetalleVentaDao detalleVentaDao;

    @Override
    @Transactional(readOnly = true)
    public List<DetalleVenta> getDetalleVentas(boolean activos) {
        return detalleVentaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public DetalleVenta getDetalleVenta(DetalleVenta detalleVenta) {
        return detalleVentaDao.findById(detalleVenta.getVentaNumeroFactura()).orElse(null);
    }

    @Override
    @Transactional
    public void save(DetalleVenta detalleVenta) {
        detalleVentaDao.save(detalleVenta);
    }

    @Override
    @Transactional
    public void delete(DetalleVenta detalleVenta) {
        detalleVentaDao.delete(detalleVenta);
    }
}
