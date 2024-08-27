/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service.impl;

import com.example.demo.dao.ComprasDao;
import com.example.demo.domain.Compras;
import com.example.demo.service.ComprasService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ComprasServiceImpl implements ComprasService {

    @Autowired
    private ComprasDao comprasDao;

    @Override
    @Transactional(readOnly = true)
    public List<Compras> getCompras(boolean activos) {
        return comprasDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Compras getCompras(Compras compras) {
        return comprasDao.findById(compras.getCompraNumeroFactura()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Compras compras) {
        comprasDao.save(compras);
    }

    @Override
    @Transactional
    public void delete(Compras compras) {
        comprasDao.delete(compras);
    }
}
