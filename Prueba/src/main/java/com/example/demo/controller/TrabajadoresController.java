/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.domain.Trabajadores;
import com.example.demo.service.TrabajadoresService;
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
@RequestMapping("/trabajadores")
public class TrabajadoresController {

    @Autowired
    private TrabajadoresService trabajadoresService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var trabajadores = trabajadoresService.getTrabajadores(false);
        model.addAttribute("trabajadores", trabajadores);
        model.addAttribute("totalTrabajadores", trabajadores.size());
        return "trabajadores/listado"; // Asegúrate de que esta ruta sea correcta
    }

    @GetMapping("/nuevo")
    public String trabajadoresNuevo(Trabajadores trabajadores) {
        return "trabajadores/modifica";
    }

    @PostMapping("/guardar")
    public String trabajadoresGuardar(Trabajadores trabajadores) {
        trabajadoresService.save(trabajadores);
        return "redirect:/trabajadores/listado";
    }

    @GetMapping("/eliminar/{cedula}")
    public String trabajadoresEliminar(Trabajadores trabajadores) {
        trabajadoresService.delete(trabajadores);
        return "redirect:/trabajadores/listado";
    }
    
    
    @GetMapping("/modificar/{cedula}")
    public String Modificar(@PathVariable("cedula") String cedula, Model model) {
        List<Trabajadores> lista = trabajadoresService.getTrabajadores(true);

        Trabajadores trabajador = lista.stream()
                                       .filter(p -> p.getCedula().equals(cedula))
                                       .findFirst()
                                       .orElse(null);
        if (trabajador == null) {
            return "redirect:/error";
        }
        model.addAttribute("trabajador", trabajador);
        return "trabajadores/modificar";
    }


    @PostMapping("/insert")
    public String insert( @RequestParam String CEDULA, @RequestParam String NOMBRE, @RequestParam String APELLIDO, @RequestParam String EMAIL, @RequestParam String TELEFONO, @RequestParam String TURNO, @RequestParam String CARGO_ID, @RequestParam String GAFETES_DE_ID, Model model) {
        int num1 = Integer.parseInt(CARGO_ID);
        int num2 = Integer.parseInt(GAFETES_DE_ID);
        trabajadoresService.insert( CEDULA,  NOMBRE,  APELLIDO, EMAIL, TELEFONO,  TURNO,  num1, num2);
        return "redirect:/trabajadores/listado";
    }
    
    @PostMapping("/delete")
    public String delete(@RequestParam String CEDULA,  Model model) {
        trabajadoresService.detel(CEDULA);
        return "redirect:/trabajadores/listado";
    }
    
    
    @PostMapping("/update")
    public String update(@ModelAttribute Trabajadores trabajadores, Model model) {
        String var1 = String.valueOf(trabajadores.getCargo().getCargoId());
        String var2 = String.valueOf(trabajadores.getGafetes().getGafetesDeId());
        
        int num1 = Integer.parseInt(var1);
        int num2 = Integer.parseInt(var2);
        trabajadoresService.update(trabajadores.getCedula(), trabajadores.getNombre(), trabajadores.getApellido(), trabajadores.getEmail(), trabajadores.getTelefono(), trabajadores.getTurno(), num1, num2);
        return "redirect:/trabajadores/listado";
    }
    
    @GetMapping("/filtrarPorNombreEmpleado")
    public String trabajadoresFiltrados(@RequestParam("nombre") String nombre, Model model) {
        // Llamada al servicio para obtener los trabajadores filtrados por nombre
        String trabajadoresFiltrados = trabajadoresService.getTrabajadoresFiltradosPorNombre(nombre);
        model.addAttribute("trabajadoresFiltrados", trabajadoresFiltrados);
        return "index";  // Asegúrate de que este sea el nombre de tu vista principal
    }
}
