/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.domain.EmpresaEncargada;
import com.example.demo.service.EmpresaEncargadaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/empresaencargada")
public class EmpresaEncargadaController {

    @Autowired
    private EmpresaEncargadaService empresaEncargadaService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var empresaEncargada = empresaEncargadaService.getEmpresaEncargada(false);
        model.addAttribute("empresaEncargada", empresaEncargada);
        model.addAttribute("totalEmpresaEncargada", empresaEncargada.size());
        return "empresaEncargada/listado"; // Asegúrate de que esta ruta sea correcta
    }

    @GetMapping("/nuevo")
    public String empresaEncargadaNuevo(EmpresaEncargada empresaEncargada) {
        return "empresaEncargada/modifica";
    }

    @PostMapping("/guardar")
    public String empresaEncargadaGuardar(EmpresaEncargada empresaEncargada) {
        empresaEncargadaService.save(empresaEncargada);
        return "redirect:/empresaEncargada/listado";
    }

    @GetMapping("/eliminar/{empresaId}")
    public String empresaEncargadaEliminar(EmpresaEncargada empresaEncargada) {
        empresaEncargadaService.delete(empresaEncargada);
        return "redirect:/empresaEncargada/listado";
    }

    @GetMapping("/modificar/{empresaId}")
    public String empresaEncargadaModificar(EmpresaEncargada empresaEncargada, Model model) {
        empresaEncargada = empresaEncargadaService.getEmpresaEncargada(empresaEncargada);
        model.addAttribute("empresaEncargada", empresaEncargada);
        return "empresaEncargada/modifica";
    }
}
