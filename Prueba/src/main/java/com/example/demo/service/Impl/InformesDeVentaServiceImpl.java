/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service.impl;

import com.example.demo.dao.InformesDeVentaDao;
import com.example.demo.domain.InformesDeVenta;
import com.example.demo.service.InformesDeVentaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InformesDeVentaServiceImpl implements InformesDeVentaService {

    @Autowired
    private InformesDeVentaDao informesDeVentaDao;

    @Override
    @Transactional(readOnly = true)
    public List<InformesDeVenta> getInformesDeVenta(boolean activos) {
        return informesDeVentaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public InformesDeVenta getInformesDeVenta(InformesDeVenta informesDeVenta) {
        return informesDeVentaDao.findById(informesDeVenta.getInformeId()).orElse(null);
    }

    @Override
    @Transactional
    public void save(InformesDeVenta informesDeVenta) {
        informesDeVentaDao.save(informesDeVenta);
    }

    @Override
    @Transactional
    public void delete(InformesDeVenta informesDeVenta) {
        informesDeVentaDao.delete(informesDeVenta);
    }
}
