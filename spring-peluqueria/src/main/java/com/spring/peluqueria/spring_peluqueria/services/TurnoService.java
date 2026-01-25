package com.spring.peluqueria.spring_peluqueria.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.peluqueria.spring_peluqueria.model.Turno;

public interface TurnoService extends JpaRepository<Turno, Long> {
    
}
