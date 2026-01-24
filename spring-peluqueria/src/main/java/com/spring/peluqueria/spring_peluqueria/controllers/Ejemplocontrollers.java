package com.spring.peluqueria.spring_peluqueria.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class Ejemplocontrollers {

    @GetMapping("/saludo")
    public String saludar() {
        return "Hola!!";
    }
    
    
}
