/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.domain.Gafetes;
import com.example.demo.service.GafetesService;
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
@RequestMapping("/gafetes")
public class GafetesController {

    @Autowired
    private GafetesService gafetesService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var gafetes = gafetesService.getGafetes(false);
        model.addAttribute("gafetes", gafetes);
        model.addAttribute("totalGafetes", gafetes.size());
        return "gafetes/listado"; // Asegúrate de que esta ruta sea correcta
    }

    @GetMapping("/nuevo")
    public String gafetesNuevo(Gafetes gafetes) {
        return "gafetes/modifica";
    }

    @PostMapping("/guardar")
    public String gafetesGuardar(Gafetes gafetes) {
        gafetesService.save(gafetes);
        return "redirect:/gafetes/listado";
    }

    @GetMapping("/eliminar/{gafetesDeId}")
    public String gafetesEliminar(Gafetes gafetes) {
        gafetesService.delete(gafetes);
        return "redirect:/gafetes/listado";
    }

    @GetMapping("/modificar/{gafetesDeId}")
    public String Modificar(@PathVariable("gafetesDeId") int gafetesDeId, Model model) {
        List<Gafetes> List = gafetesService.getGafetes(true);

        Gafetes gafete = List.stream()
                                               .filter(p -> p.getGafetesDeId() == gafetesDeId)
                                               .findFirst()
                                               .orElse(null);
        if (gafete == null) {
            return "redirect:/error";
        }
        model.addAttribute("gafete", gafete);
        return "gafetes/modificar";
    }

    @PostMapping("/insert")
    public String insert(@RequestParam int GAFETEID, @RequestParam String DESCRIPCION, Model model) {
        gafetesService.insert(GAFETEID, DESCRIPCION);
        return "redirect:/gafetes/listado";
    }
    
    @PostMapping("/delete")
    public String delete(@RequestParam String GAFETEID,  Model model) {
        int id = Integer.parseInt(GAFETEID);
        gafetesService.detel(id);
        return "redirect:/gafetes/listado";
    }
    
    
    @PostMapping("/update")
    public String update(@ModelAttribute Gafetes gafetes, Model model) {
        String i = String.valueOf(gafetes.getGafetesDeId());
        int id = Integer.parseInt(i);
        gafetesService.update(id, gafetes.getDescripcion());
        return "redirect:/gafetes/listado";
    }

    
    
}
