/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.domain.DetalleVenta;
import com.example.demo.service.DetalleVentaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/detalleventa")
public class DetalleVentaController {

    @Autowired
    private DetalleVentaService detalleVentaService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var detalleVenta = detalleVentaService.getDetalleVentas(false);
        model.addAttribute("detalleVenta", detalleVenta);
        model.addAttribute("totalDetalleVenta", detalleVenta.size());
        return "detalleVenta/listado"; // Asegúrate de que esta ruta sea correcta
    }

    @GetMapping("/nuevo")
    public String detalleVentaNuevo(DetalleVenta detalleVenta) {
        return "detalleVenta/modifica";
    }

    @PostMapping("/guardar")
    public String detalleVentaGuardar(DetalleVenta detalleVenta) {
        detalleVentaService.save(detalleVenta);
        return "redirect:/detalleVenta/listado";
    }

    @GetMapping("/eliminar/{detalleVentaId}")
    public String detalleVentaEliminar(DetalleVenta detalleVenta) {
        detalleVentaService.delete(detalleVenta);
        return "redirect:/detalleVenta/listado";
    }

    @GetMapping("/modificar/{detalleVentaId}")
    public String detalleVentaModificar(DetalleVenta detalleVenta, Model model) {
        detalleVenta = detalleVentaService.getDetalleVenta(detalleVenta);
        model.addAttribute("detalleVenta", detalleVenta);
        return "detalleVenta/modifica";
    }
}
