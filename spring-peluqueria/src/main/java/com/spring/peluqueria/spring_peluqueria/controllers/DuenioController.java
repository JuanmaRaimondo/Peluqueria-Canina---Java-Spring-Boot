package com.spring.peluqueria.spring_peluqueria.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.peluqueria.spring_peluqueria.model.Duenio;
import com.spring.peluqueria.spring_peluqueria.services.DuenioService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/duenio")
public class DuenioController {
    
    @Autowired
    private DuenioService duenioService;

    @PostMapping("/crear")
    public String crearDuenio(@RequestBody Duenio duenio) {
        duenioService.crearDuenio(duenio);
        
        return "duenio creado";
    }


    @DeleteMapping("/borrar/{id}")
    public String borrarDuenio(@PathVariable Long id) {
        duenioService.borrarDuenio(id);
        
        return "duenio borrado";
    }
    
    @GetMapping("/traer")
    public Duenio buscarDuenio(@RequestParam Long id) {
        return duenioService.buscarDuenio(id);
    }
    
    @GetMapping("/traerduenios")
    public List<Duenio> buscarDuenios() {
        return duenioService.traerDuenios();
    }
    

    @PutMapping("/editar/{id}")
    public String editarDuenio(@PathVariable Long id, @RequestBody Duenio duenio) {
        duenioService.editarDuenio(id, duenio);        
        return "dueño editado con exito";
    }
}
