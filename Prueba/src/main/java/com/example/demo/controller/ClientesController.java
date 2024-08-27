/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.domain.Clientes;
import com.example.demo.service.ClientesService;
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
@RequestMapping("/clientes")
public class ClientesController {

    @Autowired
    private ClientesService clientesService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var clientes = clientesService.getClientes(false);
        model.addAttribute("clientes", clientes);
        model.addAttribute("totalClientes", clientes.size());
        return "clientes/listado"; // Asegúrate de que esta ruta sea correcta
    }

    @GetMapping("/nuevo")
    public String clientesNuevo(Clientes clientes) {
        return "clientes/modifica";
    }

    @PostMapping("/guardar")
    public String clientesGuardar(Clientes clientes) {
        clientesService.save(clientes);
        return "redirect:/clientes/listado";
    }

    @GetMapping("/eliminar/{clienteId}")
    public String clientesEliminar(Clientes clientes) {
        clientesService.delete(clientes);
        return "redirect:/clientes/listado";
    }
    
    @GetMapping("/modificar/{clienteId}")
    public String Modificar(@PathVariable("clienteId") int clienteId, Model model) {
        List<Clientes> List = clientesService.getClientes(true);

        Clientes cliente = List.stream()
                                               .filter(p -> p.getClienteId() == clienteId)
                                               .findFirst()
                                               .orElse(null);
        if (cliente == null) {
            return "redirect:/error";
        }
        model.addAttribute("cliente", cliente);
        return "clientes/modificar";
    }

    @PostMapping("/insert")
    public String insert(@RequestParam int CLIENTE_ID, @RequestParam String NOMBRE, @RequestParam String APELLIDO, @RequestParam String EMAIL, @RequestParam String TELEFONO, @RequestParam String DIRECCION, Model model) {
        clientesService.insert(CLIENTE_ID, NOMBRE, APELLIDO, EMAIL, TELEFONO, DIRECCION);
        return "redirect:/clientes/listado";
    }
    
    @PostMapping("/delete")
    public String delete(@RequestParam String CLIENTE_ID,  Model model) {
        int id = Integer.parseInt(CLIENTE_ID);
        clientesService.detel(id);
        return "redirect:/clientes/listado";
    }
    
    
    @PostMapping("/update")
    public String update(@ModelAttribute Clientes clientes, Model model) {
        String i = String.valueOf(clientes.getClienteId());
        int id = Integer.parseInt(i);
        clientesService.update(id, clientes.getNombre(), clientes.getApellido(), clientes.getEmail(), clientes.getTelefono(), clientes.getDireccion());
        return "redirect:/clientes/listado";
    }
    
    @GetMapping("/filtrarPorNombreCliente")
    public String ClientesFiltrados(@RequestParam("nombre") String nombre, Model model) {
        String clientesFiltrados = clientesService.getClientesFiltradosPorNombre(nombre);
        model.addAttribute("clientesFiltrados", clientesFiltrados);
        return "index";
    }
}
