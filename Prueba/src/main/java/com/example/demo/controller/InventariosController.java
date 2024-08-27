/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.domain.Inventarios;
import com.example.demo.service.InventariosService;
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
@RequestMapping("/inventarios")
public class InventariosController {

    @Autowired
    private InventariosService inventariosService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var inventarios = inventariosService.getInventarios(false);
        model.addAttribute("inventarios", inventarios);
        model.addAttribute("totalInventarios", inventarios.size());
        return "inventarios/listado"; // Asegúrate de que esta ruta sea correcta
    }

    @GetMapping("/nuevo")
    public String inventariosNuevo(Inventarios inventarios) {
        return "inventarios/modifica";
    }

    @PostMapping("/guardar")
    public String inventariosGuardar(Inventarios inventarios) {
        inventariosService.save(inventarios);
        return "redirect:/inventarios/listado";
    }

    @GetMapping("/eliminar/{productoId}")
    public String inventariosEliminar(Inventarios inventarios) {
        inventariosService.delete(inventarios);
        return "redirect:/inventarios/listado";
    }

    
    @GetMapping("/modificar/{productoID}")
    public String proveedoresModificar(@PathVariable("productoID") int productoID, Model model) {
        List<Inventarios> proveedoresList = inventariosService.getInventarios(true);

        Inventarios inventario = proveedoresList.stream()
                                               .filter(p -> p.getProductoID() == productoID)
                                               .findFirst()
                                               .orElse(null);
        if (inventario == null) {
            return "redirect:/error";
        }
        model.addAttribute("inventario", inventario);
        return "inventarios/modificar";
    }

    @PostMapping("/insert")
    public String insertProveedor(@RequestParam String PRODUCTO_ID, @RequestParam String CANTIDAD_STOCK, Model model) {
        int num1 = Integer.parseInt(PRODUCTO_ID);
        int num2 = Integer.parseInt(CANTIDAD_STOCK);
        inventariosService.insert(num1, num2);
        return "redirect:/inventarios/listado";
    }
    
    @PostMapping("/delete")
    public String deleteProveedor(@RequestParam String PRODUCTO_ID,  Model model) {
        int id = Integer.parseInt(PRODUCTO_ID);
        inventariosService.detel(id);
        return "redirect:/inventarios/listado";
    }
    
    @PostMapping("/update")
    public String updateProveedor(@ModelAttribute Inventarios inventarios, Model model) {
        String i = String.valueOf(inventarios.getProducto().getProductoId());          
        int id = Integer.parseInt(i);
        inventariosService.update(id, inventarios.getCantidadStock());
        return "redirect:/inventarios/listado";
    }
    
}
