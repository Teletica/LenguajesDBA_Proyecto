/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service.impl;

import com.example.demo.dao.EmpresaEncargadaDao;
import com.example.demo.domain.EmpresaEncargada;
import com.example.demo.service.EmpresaEncargadaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpresaEncargadaServiceImpl implements EmpresaEncargadaService {

    @Autowired
    private EmpresaEncargadaDao empresaEncargadaDao;

    @Override
    @Transactional(readOnly = true)
    public List<EmpresaEncargada> getEmpresaEncargada(boolean activos) {
        return empresaEncargadaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public EmpresaEncargada getEmpresaEncargada(EmpresaEncargada empresaEncargada) {
        return empresaEncargadaDao.findById(empresaEncargada.getEmpresaId()).orElse(null);
    }

    @Override
    @Transactional
    public void save(EmpresaEncargada empresaEncargada) {
        empresaEncargadaDao.save(empresaEncargada);
    }

    @Override
    @Transactional
    public void delete(EmpresaEncargada empresaEncargada) {
        empresaEncargadaDao.delete(empresaEncargada);
    }
}
