package com.spring.peluqueria.spring_peluqueria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.peluqueria.spring_peluqueria.model.Mascota;
import com.spring.peluqueria.spring_peluqueria.repository.MascotaRepository;

@Service
public class MascotaService {

    @Autowired
    private MascotaRepository mascotarepo;

    public void crearMascota(Mascota masco) {
        mascotarepo.save(masco);
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
