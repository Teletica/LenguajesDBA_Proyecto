/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.domain.Cargo;
import com.example.demo.service.CargoService;
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
@RequestMapping("/cargo")
public class CargoController {

    @Autowired
    private CargoService cargoService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var cargos = cargoService.getCargos(false);
        model.addAttribute("cargos", cargos);
        model.addAttribute("totalCargos", cargos.size());
        return "cargo/listado";
    }

    @GetMapping("/nuevo")
    public String cargoNuevo(Cargo cargo) {
        return "cargo/modifica";
    }

    @PostMapping("/guardar")
    public String cargoGuardar(Cargo cargo) {
        cargoService.save(cargo);
        return "redirect:/cargo/listado";
    }

    @GetMapping("/eliminar/{cargoId}")
    public String cargoEliminar(Cargo cargo) {
        cargoService.delete(cargo);
        return "redirect:/cargo/listado";
    }

     @GetMapping("/modificar/{cargoId}")
    public String Modificar(@PathVariable("cargoId") int cargoId, Model model) {
        List<Cargo> List = cargoService.getCargos(true);

        Cargo item = List.stream()
                                               .filter(p -> p.getCargoId() == cargoId)
                                               .findFirst()
                                               .orElse(null);
        if (item == null) {
            return "redirect:/error";
        }
        model.addAttribute("item", item);
        return "cargo/modificar";
    }

    @PostMapping("/insert")
    public String insert(@RequestParam int CARGOID, @RequestParam String DESCRIPCION, Model model) {
        
        cargoService.insert(CARGOID, DESCRIPCION);
        return "redirect:/cargo/listado";
    }
    
    @PostMapping("/delete")
    public String delete(@RequestParam String CARGOID,  Model model) {
        int id = Integer.parseInt(CARGOID);
        cargoService.detel(id);
        return "redirect:/cargo/listado";
    }
    
    
    @PostMapping("/update")
    public String update(@ModelAttribute Cargo cargo, Model model) {
        String i = String.valueOf(cargo.getCargoId());
        String id2 = String.valueOf(cargo.getCargoId());
        int id = Integer.parseInt(id2);
        cargoService.update(id, cargo.getDescripcion());
        return "redirect:/cargo/listado";
    }

}
