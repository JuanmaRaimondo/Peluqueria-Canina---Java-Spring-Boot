package com.spring.peluqueria.spring_peluqueria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.peluqueria.spring_peluqueria.model.Servicio;
import com.spring.peluqueria.spring_peluqueria.repository.IServiceRepository;


@Service
public class ServicioService {
    
    @Autowired
    private IServiceRepository serviciorepo;


    public void crearServicio(Servicio service){
        serviciorepo.save(service);
    }

    public void borrarServicio(Long id){
        serviciorepo.deleteById(id);
    }

    public Servicio encontrarServicio(Long id_producto){
        Servicio servicioEncontrado = serviciorepo.findById(id_producto).orElse(null);
        return servicioEncontrado;
    }


}
