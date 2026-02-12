package com.spring.peluqueria.spring_peluqueria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.peluqueria.spring_peluqueria.model.Venta;
import com.spring.peluqueria.spring_peluqueria.services.VentaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;




@RestController
@RequestMapping("/api/venta")
public class VentaController {
    
    @Autowired
    private VentaService ventaservice;

    @PostMapping("/crear")
    public String crearVenta(@RequestBody Venta venta) {
ventaservice.crearVenta(venta);        
        return "Venta Creada";
    }

    @GetMapping("/traerventas")
    public List <Venta> traerventa() {
        return ventaservice.traerVentas();
    }
    
    
}
