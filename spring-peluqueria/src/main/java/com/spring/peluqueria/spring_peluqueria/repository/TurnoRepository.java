package com.spring.peluqueria.spring_peluqueria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.peluqueria.spring_peluqueria.model.Turno;

public interface TurnoRepository extends JpaRepository<Turno, Long> {
    
}
