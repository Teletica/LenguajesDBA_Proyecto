/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.domain.Categorias;
import com.example.demo.service.CategoriasService;
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
@RequestMapping("/categorias")
public class CategoriasController {

    @Autowired
    private CategoriasService categoriasService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var categorias = categoriasService.getCategorias(false);
        model.addAttribute("categorias", categorias);
        model.addAttribute("totalCategorias", categorias.size());
        return "categorias/listado"; // Asegúrate de que esta ruta sea correcta
    }

    @GetMapping("/nuevo")
    public String categoriasNuevo(Categorias categorias) {
        return "categorias/modifica";
    }

    @PostMapping("/guardar")
    public String categoriasGuardar(Categorias categorias) {
        categoriasService.save(categorias);
        return "redirect:/categorias/listado";
    }

    @GetMapping("/eliminar/{categoriaId}")
    public String categoriasEliminar(Categorias categorias) {
        categoriasService.delete(categorias);
        return "redirect:/categorias/listado";
    }

    @GetMapping("/modificar/{categoriaId}")
    public String Modificar(@PathVariable("categoriaId") int categoriaId, Model model) {
        List<Categorias> List = categoriasService.getCategorias(true);

        Categorias categoria = List.stream()
                                .filter(p -> p.getCategoriaId() == categoriaId)
                                .findFirst()
                                .orElse(null);
        if (categoria == null) {
            return "redirect:/error";
        }
        model.addAttribute("categoria", categoria);
        return "categorias/modificar";
    }

    @PostMapping("/insert")
    public String insert(@RequestParam String NOMBRE, @RequestParam String DESCRIPCION, Model model) {
        int ID = 1;
        categoriasService.insert(ID, NOMBRE, DESCRIPCION);
        return "redirect:/categorias/listado";
    }
    
    @PostMapping("/delete")
    public String delete(@RequestParam String categoriaId,  Model model) {
        int id = Integer.parseInt(categoriaId);
        categoriasService.detel(id);
        return "redirect:/categorias/listado";
    }
    
    
    @PostMapping("/update")
    public String update(@ModelAttribute Categorias categorias, Model model) {
        String i = String.valueOf(categorias.getCategoriaId());
        int id = Integer.parseInt(i);
        categoriasService.update(id, categorias.getNombre(), categorias.getDescripcion());
        return "redirect:/categorias/listado";
    }

}
