package com.spring.peluqueria.spring_peluqueria.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class TurnoDTO {
    private Long id;
    private LocalDate fecha;
    private LocalTime hora;
    private String estado;
    private String nombreMascota;
    private String nombreDuenio;

    public TurnoDTO(){}

    public TurnoDTO(Long id, LocalDate fecha, LocalTime hora, String estado, String nombreMascota,
            String nombreDuenio) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
        this.nombreMascota = nombreMascota;
        this.nombreDuenio = nombreDuenio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getNombreDuenio() {
        return nombreDuenio;
    }

    public void setNombreDuenio(String nombreDuenio) {
        this.nombreDuenio = nombreDuenio;
    }
    
    
}
