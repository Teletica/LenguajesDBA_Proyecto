/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.domain.InformesDeVenta;
import com.example.demo.service.InformesDeVentaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/informesdeventa")
public class InformesDeVentaController {

    @Autowired
    private InformesDeVentaService informesDeVentaService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var informesDeVenta = informesDeVentaService.getInformesDeVenta(false);
        model.addAttribute("informesDeVenta", informesDeVenta);
        model.addAttribute("totalInformesDeVenta", informesDeVenta.size());
        return "informesDeVenta/listado"; // Asegúrate de que esta ruta sea correcta
    }

    @GetMapping("/nuevo")
    public String informesDeVentaNuevo(InformesDeVenta informesDeVenta) {
        return "informesDeVenta/modifica";
    }

    @PostMapping("/guardar")
    public String informesDeVentaGuardar(InformesDeVenta informesDeVenta) {
        informesDeVentaService.save(informesDeVenta);
        return "redirect:/informesDeVenta/listado";
    }

    @GetMapping("/eliminar/{informeId}")
    public String informesDeVentaEliminar(InformesDeVenta informesDeVenta) {
        informesDeVentaService.delete(informesDeVenta);
        return "redirect:/informesDeVenta/listado";
    }

    @GetMapping("/modificar/{informeId}")
    public String informesDeVentaModificar(InformesDeVenta informesDeVenta, Model model) {
        informesDeVenta = informesDeVentaService.getInformesDeVenta(informesDeVenta);
        model.addAttribute("informesDeVenta", informesDeVenta);
        return "informesDeVenta/modifica";
    }
}
