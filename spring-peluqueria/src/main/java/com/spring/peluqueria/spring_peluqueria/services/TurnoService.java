package com.spring.peluqueria.spring_peluqueria.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.peluqueria.spring_peluqueria.dto.TurnoDTO;
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

    public List<TurnoDTO> buscarPorFechas(LocalDate fecha){
        List<Turno> encontrados = turnorepo.buscarPorFecha(fecha);
        List<TurnoDTO> fechasDTO = new ArrayList<>();
        for(Turno turno : encontrados){
            TurnoDTO dto = new TurnoDTO();
             dto.setId(turno.getId());
            dto.setFecha(turno.getDia());
            dto.setHora(turno.getHora());
            dto.setEstado(turno.getEstado());
           if (turno.getMascota() != null) {
                dto.setNombreMascota(turno.getMascota().getNombre());
                if (turno.getMascota().getUnDuenio() != null) {
                    dto.setNombreDuenio(turno.getMascota().getUnDuenio().getNombre());
                } else {
                    dto.setNombreDuenio("Sin Dueño");
                }
            } else {
                dto.setNombreMascota("Sin Mascota");
                dto.setNombreDuenio("Sin Dueño");
            }
            fechasDTO.add(dto);
        }
        return fechasDTO;
    }

    public List<TurnoDTO> traerTurnos(){
        List<Turno> listaTurnos = turnorepo.findAll();
        List<TurnoDTO> listaDtos = new ArrayList<>();
        for (Turno turno : listaTurnos) {
          
            TurnoDTO dto = new TurnoDTO();
            dto.setId(turno.getId());
            dto.setFecha(turno.getDia());
            dto.setHora(turno.getHora());
            dto.setEstado(turno.getEstado());
            dto.setNombreDuenio(turno.getMascota().getUnDuenio().getNombre());
            dto.setNombreMascota(turno.getMascota().getNombre());
            listaDtos.add(dto);
        }
        return listaDtos;
    }

    public Turno traerTurno(Long id){
        return turnorepo.findById(id).orElse(null);
    }



    

}
