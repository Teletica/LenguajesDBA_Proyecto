/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service.Impl;

import com.example.demo.dao.ProductosDao;
import com.example.demo.domain.Productos;
import com.example.demo.service.ProductosService;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author gabriel badilla
 */
@Service
public class ProductosServiceImpl implements ProductosService{
    
    @Autowired
    private ProductosDao productosDao;

    @Override
    @Transactional(readOnly = true)
    public List<Productos> getProductos(boolean activos) {
        return productosDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Productos getProductos(Productos productos) {
        return productosDao.findById(productos.getProductoId()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Productos productos) {
        productosDao.save(productos);
    }

    @Override
    @Transactional
    public void delete(Productos productos) {
        productosDao.delete(productos);
    }
    
    
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert( int T_PRODUCTO_ID, String  T_NOMBRE, int  T_PRECIO_VENTA, Date T_FECHA_CADUCIDAD, int T_PROVEEDOR_ID, int T_CATEGORIA_ID) {                  
        jdbcTemplate.update("CALL INSERTAR_PRODUCTO(?, ?, ?, ?, ?, ?)",  T_PRODUCTO_ID,   T_NOMBRE,   T_PRECIO_VENTA,  T_FECHA_CADUCIDAD,  T_PROVEEDOR_ID,  T_CATEGORIA_ID);
    }
    

    public void detel( int T_PRODUCTO_ID) {                  
        jdbcTemplate.update("CALL ELIMINAR_PRODUCTO(?)", T_PRODUCTO_ID);
    }
    

    public void update( int T_PRODUCTO_ID, String  T_NOMBRE, double  T_PRECIO_VENTA, Date T_FECHA_CADUCIDAD, int T_PROVEEDOR_ID, int T_CATEGORIA_ID) {                  
        jdbcTemplate.update("CALL MODIFICAR_PRODUCTO(?, ?, ?, ?, ?, ?)", T_PRODUCTO_ID,   T_NOMBRE,   T_PRECIO_VENTA,  T_FECHA_CADUCIDAD,  T_PROVEEDOR_ID,  T_CATEGORIA_ID);
    }
    
    @Override
    public String getProductosFiltradosPorNombre(String nombre) {
        String resultado = "";
        try {
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "HR", "HR");
            CallableStatement callableStatement = connection.prepareCall("{ ? = call FILTRADO_PRODUCTOS(?) }");
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
