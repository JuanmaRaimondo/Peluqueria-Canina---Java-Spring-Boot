package com.spring.peluqueria.spring_peluqueria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.peluqueria.spring_peluqueria.dto.MascotaDTO;
import com.spring.peluqueria.spring_peluqueria.model.Duenio;
import com.spring.peluqueria.spring_peluqueria.model.Mascota;
import com.spring.peluqueria.spring_peluqueria.repository.IDuenioRepository;
import com.spring.peluqueria.spring_peluqueria.repository.IMascotaRepository;

@Service
public class MascotaService {

    @Autowired
    private IMascotaRepository mascotarepo;

    @Autowired
private IDuenioRepository duenioRepo;

    public void crearMascota(MascotaDTO masco, Long id_duenio) {

        Mascota mascotaNueva = new Mascota();
        
        mascotaNueva.setNombre(masco.getNombreMascota()); 
        mascotaNueva.setRaza(masco.getRaza());

      Duenio duenioEncontrado =  duenioRepo.findById(id_duenio).orElse(null);
      if(duenioEncontrado != null){
        mascotaNueva.setUnDuenio(duenioEncontrado);
      }
        mascotarepo.save(mascotaNueva);
        
    }

    public List<Mascota> traerMascotas() {
        return mascotarepo.findAll();
    }

    public void borrarMascota(Long id_mascota) {
        mascotarepo.deleteById(id_mascota);
    }
    
    public Mascota buscarMascota(Long id_mascota) {
       
        return mascotarepo.findById(id_mascota).orElse(null);
    }

    public void editarMascota(Long id_mascota, Mascota masco ){
        Mascota mascotaEncontrada = mascotarepo.findById(id_mascota).orElse(null);
        if(mascotaEncontrada != null){
            mascotaEncontrada.setNombre(masco.getNombre());
            mascotaEncontrada.setObservaciones(masco.getObservaciones());
            mascotaEncontrada.setRaza(masco.getRaza());
            mascotaEncontrada.setUnDuenio(masco.getUnDuenio());
            mascotarepo.save(mascotaEncontrada);
        }

    }
    
}
