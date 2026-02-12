package com.spring.peluqueria.spring_peluqueria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.peluqueria.spring_peluqueria.model.Producto;
import com.spring.peluqueria.spring_peluqueria.services.ProductoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    
    @Autowired
   private ProductoService productoService;
   
   @PostMapping("/crear")
   public String crearProducto(@RequestBody Producto producto) {
        productoService.crearProducto(producto);       
       return "¡Producto Creado exitosamente!";
   }

   @GetMapping("/traer")
   public Producto traerProducto(@RequestParam Long id_producto) {
       return  productoService.encontrarProducto(id_producto);
   }
   
   @GetMapping("/listaproductos")
   public List<Producto> traerproductos() {
        return productoService.listarProductos() ;
   }

   @PutMapping("editar/{id_producto}")
   public Producto editarProducto(@PathVariable Long id_producto, @RequestBody Producto producto) {
          
                productoService.editarProducto(id_producto, producto);
       return producto;
   }
   
   @DeleteMapping("eliminar/{id_producto}")
   public String borrarProducto(@PathVariable Long id_producto){
    productoService.borrarProducto(id_producto);
    return "Producto eliminado";
   }

}
