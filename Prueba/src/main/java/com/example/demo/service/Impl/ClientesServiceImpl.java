/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service.impl;

import com.example.demo.dao.ClientesDao;
import com.example.demo.domain.Clientes;
import com.example.demo.service.ClientesService;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientesServiceImpl implements ClientesService {

    @Autowired
    private ClientesDao clientesDao;

    @Override
    @Transactional(readOnly = true)
    public List<Clientes> getClientes(boolean activos) {
        return clientesDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Clientes getClientes(Clientes clientes) {
        return clientesDao.findById(clientes.getClienteId()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Clientes clientes) {
        clientesDao.save(clientes);
    }

    @Override
    @Transactional
    public void delete(Clientes clientes) {
        clientesDao.delete(clientes);
    }
    
    
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(int T_CLIENTE_ID, String T_NOMBRE, String T_APELLIDO, String T_EMAIL, String T_TELEFONO, String T_DIRECCION) {                  
        jdbcTemplate.update("CALL INSERTAR_CLIENTE(?, ?, ?, ?, ?, ?)", T_CLIENTE_ID, T_NOMBRE, T_APELLIDO, T_EMAIL, T_TELEFONO, T_DIRECCION);
    }
    
    public void detel( int T_CLIENTE_ID) {                  
        jdbcTemplate.update("CALL ELIMINAR_CLIENTE(?)", T_CLIENTE_ID);
    }
    
    public void update( int T_CLIENTE_ID, String T_NOMBRE, String T_APELLIDO, String T_EMAIL, String T_TELEFONO, String T_DIRECCION) {                  
        jdbcTemplate.update("CALL MODIFICAR_CLIENTE(?, ?, ?, ?, ?, ?)", T_CLIENTE_ID, T_NOMBRE, T_APELLIDO, T_EMAIL, T_TELEFONO, T_DIRECCION);
    }

    @Override
    public String getClientesFiltradosPorNombre(String nombre) {
        String resultado = "";
        try {
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "HR", "HR");
            CallableStatement callableStatement = connection.prepareCall("{ ? = call FILTRADO_CLIENTES(?) }");
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
