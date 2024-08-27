/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.domain.EmpresaEncargada;
import java.util.List;

public interface EmpresaEncargadaService {
    public List<EmpresaEncargada> getEmpresaEncargada(boolean activos);
    
    public EmpresaEncargada getEmpresaEncargada(EmpresaEncargada empresaEncargada);
    
    public void save(EmpresaEncargada empresaEncargada);
    
    public void delete(EmpresaEncargada empresaEncargada);
}
