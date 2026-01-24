package com.spring.peluqueria.spring_peluqueria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.peluqueria.spring_peluqueria.model.Duenio;
import com.spring.peluqueria.spring_peluqueria.repository.DuenioRepository;

@Service
public class DuenioService {
    
    @Autowired
    private DuenioRepository dueniorepo;

    public void crearDuenio(Duenio duenio){
        dueniorepo.save(duenio);
    }

    public List<Duenio> traerDuenios(){
        return dueniorepo.findAll();
    }

    public void borrarDuenio(Long id){
        dueniorepo.deleteById(id);
    }

    public Duenio buscarDuenio(Long id_duenio){
        return dueniorepo.findById(id_duenio).orElse(null);
    }

    public void editarDuenio(Long id_duenio, Duenio duenio){
    Duenio duenio_encontrado =  dueniorepo.findById(id_duenio).orElse(null);
        if(duenio_encontrado != null){
            duenio_encontrado.setNombre(duenio.getNombre());
            duenio_encontrado.setApellido(duenio.getApellido());
            duenio_encontrado.setDireccion(duenio.getDireccion());
            dueniorepo.save(duenio_encontrado);
        }
       
    }
}
