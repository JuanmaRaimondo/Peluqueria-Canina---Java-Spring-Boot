package com.spring.peluqueria.spring_peluqueria.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.peluqueria.spring_peluqueria.model.Turno;
import com.spring.peluqueria.spring_peluqueria.repository.TurnoRepository;

@Service
public class TurnoService{
    
    @Autowired
    private TurnoRepository turnorepo;
    LocalDate hoy = LocalDate.now();
    LocalTime ahora = LocalTime.now();
    public void crearTurno(Turno turno){
        if (turno.getDia().isBefore(hoy) || (turno.getDia().isEqual(hoy) && turno.getHora().isBefore(ahora)) ) {
            throw new IllegalArgumentException("No se puede crear turnos con fechas pasadas");
        }
            turno.setEstado("Confirmado");
        
        turnorepo.save(turno);
    }

    public void borrarTurnos(Long id){
        Turno turno = turnorepo.findById(id)
            .orElseThrow(() -> new RuntimeException("No se encuentran turnos"));
        turno.setEstado("Cancelado");
        turnorepo.save(turno);
    }

    public List<Turno> traerTurnos(){
        return turnorepo.findAll();
    }

    public Turno traerTurno(Long id){
        return turnorepo.findById(id).orElse(null);
    }



    

}
