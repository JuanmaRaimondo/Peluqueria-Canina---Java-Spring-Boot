package com.spring.peluqueria.spring_peluqueria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.spring.peluqueria.spring_peluqueria.model.Duenio;
import com.spring.peluqueria.spring_peluqueria.model.Mascota;
import com.spring.peluqueria.spring_peluqueria.repository.DuenioRepository;
import com.spring.peluqueria.spring_peluqueria.repository.MascotaRepository;

@Component
public class CargaDeDatos implements CommandLineRunner {

    @Autowired
    private DuenioRepository duenioRepo;

    @Autowired
    private MascotaRepository mascotaRepo;

    @Override
    public void run(String... args) throws Exception {
        
        // --- 1. CREAMOS 5 DUEÑOS ---
        Duenio d1 = new Duenio( null, "Juan", "Perez", "111111");
        Duenio d2 = new Duenio(null, "Maria", "Gomez", "222222");
        Duenio d3 = new Duenio(null, "Carlos", "Lopez", "333333");
        Duenio d4 = new Duenio(null, "Ana", "Diaz", "444444");
        Duenio d5 = new Duenio(null, "Luis", "Torres", "555555");

        // Guardamos los dueños (ahora la BD les asigna IDs 1, 2, 3, 4, 5)
        duenioRepo.save(d1);
        duenioRepo.save(d2);
        duenioRepo.save(d3);
        duenioRepo.save(d4);
        duenioRepo.save(d5);

        // --- 2. CREAMOS 5 MASCOTAS (Cada una con su dueño) ---
        // Fíjate que le paso el OBJETO dueño entero (d1, d2...), no el ID.
        
        Mascota m1 = new Mascota(null, "Firulais", "Caniche", "Blanco", d1);
        Mascota m2 = new Mascota(null, "Rex", "Ovejero", "Marron", d2);
        Mascota m3 = new Mascota(null, "Lola", "Beagle", "Tricolor", d3);
        Mascota m4 = new Mascota(null, "Luna", "Gato", "Negro", d4);
        Mascota m5 = new Mascota(null, "Rocky", "Bulldog", "Gris", d5);
        Mascota mExtra = new Mascota(null, "Hércules", "Doberman", "Negro", d1);


System.out.println("✅ Ahora Juan tiene 2 perros");

        mascotaRepo.save(m1);
        mascotaRepo.save(m2);
        mascotaRepo.save(m3);
        mascotaRepo.save(m4);
        mascotaRepo.save(m5);
        mascotaRepo.save(mExtra);
        System.out.println("--------------------------------------------");
        System.out.println("✅ DATOS DE PRUEBA CARGADOS EXITOSAMENTE");
        System.out.println("--------------------------------------------");
    }
}
