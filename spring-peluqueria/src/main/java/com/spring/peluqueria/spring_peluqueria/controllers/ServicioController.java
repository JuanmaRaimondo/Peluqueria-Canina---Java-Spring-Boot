package com.spring.peluqueria.spring_peluqueria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.peluqueria.spring_peluqueria.model.Servicio;
import com.spring.peluqueria.spring_peluqueria.services.ServicioService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/servicios")
public class ServicioController {
    
    @Autowired
    private ServicioService servicioservice;

    @PostMapping("/crearservicio")
    public String crearServicio(@RequestBody Servicio service) {
        servicioservice.crearServicio(service);
        
        return "Servicio creado exitosamente";
    }

    @DeleteMapping("/borrarservicio/{id}")
    public String borrarServicio(@PathVariable Long id){
        servicioservice.borrarServicio(id);

        return "Servicio borrado exitosamente";
    }

    @GetMapping("/traerservicio/{id_servicio}")
    public Servicio traerServicios(@PathVariable Long id_servicio) {
       Servicio servicioEncontrado =  servicioservice.encontrarServicio(id_servicio);
        return servicioEncontrado;
    }
    
}
