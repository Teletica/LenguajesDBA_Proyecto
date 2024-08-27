/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.domain.Productos;
import com.example.demo.service.ProductosService;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
@RequestMapping("/productos")
public class ProductosController {
    
    @Autowired
    private ProductosService productosService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var productos = productosService.getProductos(false);
        model.addAttribute("productos", productos);
        model.addAttribute("totalProductos", productos.size());
        return "productos/listado"; // Asegúrate de que esta ruta sea correcta
    }
    
    @GetMapping("/nuevo")
    public String productosNuevo(Productos productos) {
        return "productos/modifica";
    }
    
    @PostMapping("/guardar")
    public String productosGuardar(Productos productos) {        
        productosService.save(productos);
        return "redirect:/productos/listado";
    }

    @GetMapping("/eliminar/{productoId}")
    public String productosEliminar(Productos productos) {
        productosService.delete(productos);
        return "redirect:/productos/listado";
    }
    
    
    @GetMapping("/modificar/{productoId}")
    public String proveedoresModificar(@PathVariable("productoId") int productoId, Model model) {
        List<Productos> proveedoresList = productosService.getProductos(true);

        Productos producto = proveedoresList.stream()
                                               .filter(p -> p.getProductoId() == productoId)
                                               .findFirst()
                                               .orElse(null);
        if (producto == null) {
            return "redirect:/error";
        }
        model.addAttribute("producto", producto);
        return "productos/modificar";
    }

    @PostMapping("/insert")
    public String insertProveedor( @RequestParam String NOMBRE, @RequestParam int PRECIO_VENTA, @DateTimeFormat(pattern = "yyyy-MM-dd") Date FECHA_CADUCIDAD, @RequestParam int PROVEEDOR_ID, @RequestParam int CATEGORIA_ID, Model model) {
        int i = 1;
        productosService.insert(i, NOMBRE, PRECIO_VENTA, FECHA_CADUCIDAD, PROVEEDOR_ID, CATEGORIA_ID);
        return "redirect:/productos/listado";
    }
    
    @PostMapping("/delete")
    public String deleteProveedor(@RequestParam String T_PRODUCTO_ID,  Model model) {
        int id = Integer.parseInt(T_PRODUCTO_ID);
        productosService.detel(id);
        return "redirect:/productos/listado";
    }
    
    @PostMapping("/update")
    public String updateProveedor(@ModelAttribute Productos productos, Model model) {
        String i = String.valueOf(productos.getProductoId());
        String x = String.valueOf(productos.getCategoria().getCategoriaId());
        String b = String.valueOf(productos.getProveedor().getProveedorId());
        String c = String.valueOf(productos.getPrecioVenta());
        int id = Integer.parseInt(i);
        int id2 = Integer.parseInt(x);
        int id3 = Integer.parseInt(b);
        double id4 = Double.parseDouble(c);
        
        productosService.update(id, productos.getNombre(), id4, productos.getFechaCaducidad(), id3, id2);
        return "redirect:/productos/listado";
    }
    
    @GetMapping("/filtrarPorNombre")
    public String productosFiltrados(@RequestParam("nombre") String nombre, Model model) {
        // Obtén los productos filtrados por nombre
        String productosFiltrados = productosService.getProductosFiltradosPorNombre(nombre);
        model.addAttribute("productosFiltrados", productosFiltrados);
        return "index";  // Asegúrate de que este sea el nombre de tu vista principal
    }
      
}
