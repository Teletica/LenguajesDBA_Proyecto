/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service.impl;

import com.example.demo.dao.DetalleCompraDao;
import com.example.demo.domain.DetalleCompra;
import com.example.demo.service.DetalleCompraService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DetalleCompraServiceImpl implements DetalleCompraService {

    @Autowired
    private DetalleCompraDao detalleCompraDao;

    @Override
    @Transactional(readOnly = true)
    public List<DetalleCompra> getDetalleCompras(boolean activos) {
        return detalleCompraDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public DetalleCompra getDetalleCompra(DetalleCompra detalleCompra) {
        return detalleCompraDao.findById(detalleCompra.getCompraNumeroFactura()).orElse(null);
    }

    @Override
    @Transactional
    public void save(DetalleCompra detalleCompra) {
        detalleCompraDao.save(detalleCompra);
    }

    @Override
    @Transactional
    public void delete(DetalleCompra detalleCompra) {
        detalleCompraDao.delete(detalleCompra);
    }
}

