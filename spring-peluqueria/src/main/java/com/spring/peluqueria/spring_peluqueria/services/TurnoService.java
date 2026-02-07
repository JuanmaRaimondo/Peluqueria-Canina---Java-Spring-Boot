package com.spring.peluqueria.spring_peluqueria.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.peluqueria.spring_peluqueria.dto.TurnoDTO;
import com.spring.peluqueria.spring_peluqueria.dto.TurnoRequestDTO;
import com.spring.peluqueria.spring_peluqueria.model.Mascota;
import com.spring.peluqueria.spring_peluqueria.model.Turno;
import com.spring.peluqueria.spring_peluqueria.repository.MascotaRepository;
import com.spring.peluqueria.spring_peluqueria.repository.TurnoRepository;

@Service
public class TurnoService{
    
    @Autowired
    private TurnoRepository turnorepo;
    @Autowired
    private MascotaRepository mascorepo;

    LocalDate hoy = LocalDate.now();
    LocalTime ahora = LocalTime.now();

    public void crearTurno(TurnoRequestDTO request){
      Mascota mascotaEncontrada =  mascorepo.findById(request.getId_mascota()).orElse(null);

      if(mascotaEncontrada == null){
        throw new RuntimeException("No existe una mascota con ese ID");
      }
        Turno turnoNuevo = new Turno();
      turnoNuevo.setDia(request.getFecha());  
        turnoNuevo.setHora(LocalTime.parse(request.getHora()));
        turnoNuevo.setEstado("Pendiente");
        turnoNuevo.setMascota(mascotaEncontrada);
        turnorepo.save(turnoNuevo);
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
