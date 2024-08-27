/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.domain.Gafetes;
import java.util.List;

public interface GafetesService {
    public List<Gafetes> getGafetes(boolean activos);
    
    public Gafetes getGafetes(Gafetes gafetes);
    
    public void save(Gafetes gafetes);
    
    public void delete(Gafetes gafetes);



    public void insert( int T_GAFETES_ID, String T_DESCRIPCION);
    
    public void detel( int T_GAFETES_ID);
    
    public void update( int T_GAFETES_ID, String T_DESCRIPCION);
}
