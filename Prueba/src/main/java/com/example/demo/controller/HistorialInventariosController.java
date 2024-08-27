/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.domain.HistorialInventarios;
import com.example.demo.service.HistorialInventariosService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/historialinventarios")
public class HistorialInventariosController {

    @Autowired
    private HistorialInventariosService historialInventariosService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var historialinventarios = historialInventariosService.getHistorialInventarios(false);
        model.addAttribute("historialinventarios", historialinventarios);
        model.addAttribute("totalHistorialInventarios", historialinventarios.size());
        return "historialinventarios/listado"; // Asegúrate de que esta ruta sea correcta
    }

    @GetMapping("/nuevo")
    public String historialInventariosNuevo(HistorialInventarios historialInventarios) {
        return "historialinventarios/modifica";
    }

    @PostMapping("/guardar")
    public String historialInventariosGuardar(HistorialInventarios historialInventarios) {
        historialInventariosService.save(historialInventarios);
        return "redirect:/historialinventarios/listado";
    }

    @GetMapping("/eliminar/{historialId}")
    public String historialInventariosEliminar(HistorialInventarios historialInventarios) {
        historialInventariosService.delete(historialInventarios);
        return "redirect:/historialinventarios/listado";
    }

    @GetMapping("/modificar/{historialId}")
    public String historialInventariosModificar(HistorialInventarios historialinventarios, Model model) {
        historialinventarios = historialInventariosService.getHistorialInventarios(historialinventarios);
        model.addAttribute("historialinventarios", historialinventarios);
        return "historialinventarios/modifica";
    }
}
