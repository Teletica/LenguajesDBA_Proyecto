/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.domain.Ventas;
import com.example.demo.service.VentasService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/ventas")
public class VentasController {

    @Autowired
    private VentasService ventasService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var ventas = ventasService.getVentas(false);
        model.addAttribute("ventas", ventas);
        model.addAttribute("totalVentas", ventas.size());
        return "ventas/listado"; // Asegúrate de que esta ruta sea correcta
    }

    @GetMapping("/nuevo")
    public String ventasNuevo(Ventas ventas) {
        return "ventas/modifica";
    }

    @PostMapping("/guardar")
    public String ventasGuardar(Ventas ventas) {
        ventasService.save(ventas);
        return "redirect:/ventas/listado";
    }

    @GetMapping("/eliminar/{ventaNumeroFactura}")
    public String ventasEliminar(Ventas ventas) {
        ventasService.delete(ventas);
        return "redirect:/ventas/listado";
    }

    @GetMapping("/modificar/{ventaNumeroFactura}")
    public String ventasModificar(Ventas ventas, Model model) {
        ventas = ventasService.getVentas(ventas);
        model.addAttribute("ventas", ventas);
        return "ventas/modifica";
    }
}
