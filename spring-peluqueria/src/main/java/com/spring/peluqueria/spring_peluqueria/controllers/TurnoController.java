package com.spring.peluqueria.spring_peluqueria.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.spring.peluqueria.spring_peluqueria.dto.TurnoDTO;
import com.spring.peluqueria.spring_peluqueria.model.Turno;
import com.spring.peluqueria.spring_peluqueria.services.TurnoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;






@RestController
 @RequestMapping("/api/turnos")
public class TurnoController {

    @Autowired
    private TurnoService turnoservice;
   
    @PostMapping("/crear")
    public String crearTurno(@RequestBody Turno turno) {
        turnoservice.crearTurno(turno);        
            return "¡Turno creado con exito!";
    }
    
    @GetMapping("/traerturno")
    public Turno traerTurno(@PathVariable Long id) {
        return  turnoservice.traerTurno(id);
    }
    
    @GetMapping("/traerturnos")
    public List<TurnoDTO> traerTurnos( ) {
        return turnoservice.traerTurnos();    
    }
    
    @DeleteMapping("/cancelar/{id}")
    public String cancelarTurno(@PathVariable Long id){
        turnoservice.borrarTurnos(id);
        return "Borrar";
    }

    @GetMapping("/fecha/{fecha}")
    public List<TurnoDTO>  buscarPorFechas(@PathVariable LocalDate fecha) {        
        return turnoservice.buscarPorFechas(fecha);
    }
    
}
