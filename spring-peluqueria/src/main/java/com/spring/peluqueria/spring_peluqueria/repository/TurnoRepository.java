package com.spring.peluqueria.spring_peluqueria.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.peluqueria.spring_peluqueria.model.Turno;

public interface TurnoRepository extends JpaRepository<Turno, Long> {
    @Query("SELECT t FROM Turno t WHERE t.dia = :fecha")
    List<Turno> buscarPorFecha(@Param("fecha") LocalDate fecha);
}
