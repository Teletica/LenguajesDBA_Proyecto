/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.domain.Proveedores;
import com.example.demo.service.ProveedoresService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequestMapping("/proveedores")
public class ProveedoresController {

    @Autowired
    private ProveedoresService proveedoresService;
    
    @GetMapping("/listado")
    public String inicio(Model model) {
        var proveedores = proveedoresService.getProveedores(false);
        model.addAttribute("proveedores", proveedores);
        model.addAttribute("totalProveedores", proveedores.size());
        return "proveedores/listado"; // Asegúrate de que esta ruta sea correcta
    }

    @GetMapping("/nuevo")
    public String proveedoresNuevo(Proveedores proveedores) {
        return "proveedores/modifica";
    }

    @PostMapping("/guardar")
    public String proveedoresGuardar(Proveedores proveedores) {
        proveedoresService.save(proveedores);
        return "redirect:/proveedores/listado";
    }

    @GetMapping("/eliminar/{proveedorId}")
    public String proveedoresEliminar(Proveedores proveedores) {
        proveedoresService.delete(proveedores);
        return "redirect:/proveedores/listado";
    }

    @GetMapping("/modificar/{proveedorId}")
    public String proveedoresModificar(@PathVariable("proveedorId") int proveedorId, Model model) {
        List<Proveedores> proveedoresList = proveedoresService.getProveedores(true);

        Proveedores proveedor = proveedoresList.stream()
                                               .filter(p -> p.getProveedorId() == proveedorId)
                                               .findFirst()
                                               .orElse(null);
        if (proveedor == null) {
            return "redirect:/error";
        }
        model.addAttribute("proveedor", proveedor);
        return "proveedores/modificar";
    }

    @PostMapping("/insert")
    public String insertProveedor(@RequestParam String NOMBRE, @RequestParam String TELEFONO, @RequestParam String EMAIL, Model model) {
        int PROVEEDOR_ID = 1;
        proveedoresService.insertProveedor( PROVEEDOR_ID, NOMBRE, TELEFONO, EMAIL);
        return "redirect:/proveedores/listado";
    }
    
    @PostMapping("/delete")
    public String deleteProveedor(@RequestParam String PROVEEDOR_ID,  Model model) {
        int id = Integer.parseInt(PROVEEDOR_ID);
        proveedoresService.deteleProveedor(id);
        return "redirect:/proveedores/listado";
    }
    
    
    
    @PostMapping("/update")
    public String updateProveedor(@ModelAttribute Proveedores proveedor, Model model) {
        String i = String.valueOf(proveedor.getProveedorId());
        int id = Integer.parseInt(i);
        System.out.print(proveedor.getNombre());
        System.out.print(proveedor.getTelefono());
        System.out.print(proveedor.getEmail());
        proveedoresService.updateProveedor(id, proveedor.getNombre(), proveedor.getTelefono(), proveedor.getEmail());
        return "redirect:/proveedores/listado";
    }
}
