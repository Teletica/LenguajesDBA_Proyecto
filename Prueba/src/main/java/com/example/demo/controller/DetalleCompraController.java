/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.domain.DetalleCompra;
import com.example.demo.service.DetalleCompraService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/detallecompra")
public class DetalleCompraController {

    @Autowired
    private DetalleCompraService detalleCompraService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var detalleCompra = detalleCompraService.getDetalleCompras(false);
        model.addAttribute("detalleCompra", detalleCompra);
        model.addAttribute("totalDetalleCompra", detalleCompra.size());
        return "detalleCompra/listado"; // Asegúrate de que esta ruta sea correcta
    }

    @GetMapping("/nuevo")
    public String detalleCompraNuevo(DetalleCompra detalleCompra) {
        return "detalleCompra/modifica";
    }

    @PostMapping("/guardar")
    public String detalleCompraGuardar(DetalleCompra detalleCompra) {
        detalleCompraService.save(detalleCompra);
        return "redirect:/detalleCompra/listado";
    }

    @GetMapping("/eliminar/{detalleCompraId}")
    public String detalleCompraEliminar(DetalleCompra detalleCompra) {
        detalleCompraService.delete(detalleCompra);
        return "redirect:/detalleCompra/listado";
    }

    @GetMapping("/modificar/{detalleCompraId}")
    public String detalleCompraModificar(DetalleCompra detalleCompra, Model model) {
        detalleCompra = detalleCompraService.getDetalleCompra(detalleCompra);
        model.addAttribute("detalleCompra", detalleCompra);
        return "detalleCompra/modifica";
    }
}
