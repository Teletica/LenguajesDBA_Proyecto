/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service.impl;

import com.example.demo.dao.TrabajadoresDao;
import com.example.demo.domain.Trabajadores;
import com.example.demo.service.TrabajadoresService;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TrabajadoresServiceImpl implements TrabajadoresService {

    @Autowired
    private TrabajadoresDao trabajadoresDao;

    @Override
    @Transactional(readOnly = true)
    public List<Trabajadores> getTrabajadores(boolean activos) {
        return trabajadoresDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Trabajadores getTrabajadores(Trabajadores trabajadores) {
        return trabajadoresDao.findById(trabajadores.getCedula()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Trabajadores trabajadores) {
        trabajadoresDao.save(trabajadores);
    }

    @Override
    @Transactional
    public void delete(Trabajadores trabajadores) {
        trabajadoresDao.delete(trabajadores);
    }
    

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert( String T_CEDULA, String T_NOMBRE, String T_APELLIDO, String T_EMAIL, String T_TELEFONO, String T_TURNO, int T_CARGO_ID, int T_GAFETES_DE_ID) {                  
        jdbcTemplate.update("CALL INSERTAR_TRABAJADOR(?, ?, ?, ?, ?, ?, ?, ?)",  T_CEDULA,  T_NOMBRE,  T_APELLIDO,  T_EMAIL,  T_TELEFONO,  T_TURNO,  T_CARGO_ID,  T_GAFETES_DE_ID);
    }

    public void detel( String T_CEDULA) {                  
        jdbcTemplate.update("CALL ELIMINAR_TRABAJADOR(?)", T_CEDULA);
    }
    
    public void update( String T_CEDULA, String T_NOMBRE, String T_APELLIDO, String T_EMAIL, String T_TELEFONO, String T_TURNO, int T_CARGO_ID, int T_GAFETES_DE_ID) {                  
        jdbcTemplate.update("CALL MODIFICAR_TRABAJADOR(?, ?, ?, ?, ?, ?, ?, ?)", T_CEDULA,  T_NOMBRE,  T_APELLIDO,  T_EMAIL,  T_TELEFONO,  T_TURNO,  T_CARGO_ID,  T_GAFETES_DE_ID);
    }
    
    @Override
    public String getTrabajadoresFiltradosPorNombre(String nombre) {
        String resultado = "";
        try {
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "HR", "HR");
            CallableStatement callableStatement = connection.prepareCall("{ ? = call FILTRADO_EMPLEADOS(?) }");
            callableStatement.registerOutParameter(1, java.sql.Types.VARCHAR);
            callableStatement.setString(2, nombre);
            callableStatement.execute();
            resultado = callableStatement.getString(1);
            connection.close();
        } catch (Exception e) {
            resultado = "Error: " + e.getMessage();
        }
        return resultado;
    }
}
