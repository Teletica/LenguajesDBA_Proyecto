/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.dao;

import com.example.demo.domain.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleVentaDao extends JpaRepository<DetalleVenta, Long> {
}
