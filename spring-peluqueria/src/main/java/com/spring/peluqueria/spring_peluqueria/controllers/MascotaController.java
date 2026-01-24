package com.spring.peluqueria.spring_peluqueria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.peluqueria.spring_peluqueria.model.Mascota;
import com.spring.peluqueria.spring_peluqueria.services.MascotaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/mascotas")
public class MascotaController {

    @Autowired
    private MascotaService mascoservice;

    @PostMapping("/crear")
    public String crear(@RequestBody Mascota masco) {

        System.out.println("El dueño que llegó es: " + masco.getUnDuenio());
        mascoservice.crearMascota(masco);
        
        return "mascota creada";
    }
    
    @GetMapping("/traer")
    public List<Mascota> traerMascotas() {
        return mascoservice.traerMascotas();
    }
    
    @PutMapping("/editar/{id}")
    public String editarMascota(@PathVariable Long id, @RequestBody Mascota masco) {
        mascoservice.editarMascota(id, masco);
        
        return "Mascota editada con exito";
    }
}
