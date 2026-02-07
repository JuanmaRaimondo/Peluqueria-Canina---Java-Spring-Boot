package com.spring.peluqueria.spring_peluqueria.dto;

import java.time.LocalDate;


import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public class TurnoRequestDTO {

    @NotNull(message = "La fecha no puede ser nula.")
    @FutureOrPresent(message = "La fecha debe ser para hoy o en el futuro.")
    private LocalDate fecha;
    @NotNull(message = "La hora no puede ser nula.")
    @Pattern(regexp = "^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$", message = "El formato de hora debe ser HH:MM")
    private String hora;
    @NotNull(message = "el ID no puede ser nulo.")
    @Positive(message = "El ID siempre tiene que ser mayor que 0.")
    private Long id_mascota;

    public TurnoRequestDTO(){}
    public TurnoRequestDTO(LocalDate fecha, String hora, Long id_mascota) {
        this.fecha = fecha;
        this.hora = hora;
        this.id_mascota = id_mascota;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }
    public Long getId_mascota() {
        return id_mascota;
    }
    public void setId_mascota(Long id_mascota) {
        this.id_mascota = id_mascota;
    }

    
}
