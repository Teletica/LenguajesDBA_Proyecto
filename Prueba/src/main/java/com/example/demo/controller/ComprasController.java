/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.domain.Compras;
import com.example.demo.service.ComprasService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/compras")
public class ComprasController {

    @Autowired
    private ComprasService comprasService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var compras = comprasService.getCompras(false);
        model.addAttribute("compras", compras);
        model.addAttribute("totalCompras", compras.size());
        return "compras/listado"; // Asegúrate de que esta ruta sea correcta
    }

    @GetMapping("/nuevo")
    public String comprasNuevo(Compras compras) {
        return "compras/modifica";
    }

    @PostMapping("/guardar")
    public String comprasGuardar(Compras compras) {
        comprasService.save(compras);
        return "redirect:/compras/listado";
    }

    @GetMapping("/eliminar/{compraNumeroFactura}")
    public String comprasEliminar(Compras compras) {
        comprasService.delete(compras);
        return "redirect:/compras/listado";
    }

    @GetMapping("/modificar/{compraNumeroFactura}")
    public String comprasModificar(Compras compras, Model model) {
        compras = comprasService.getCompras(compras);
        model.addAttribute("compras", compras);
        return "compras/modifica";
    }
}
