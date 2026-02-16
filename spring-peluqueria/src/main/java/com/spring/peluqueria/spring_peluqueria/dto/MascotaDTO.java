package com.spring.peluqueria.spring_peluqueria.dto;



public class MascotaDTO {
    private String nombreDuenio;
    private String apellidoDuenio;
    private Long idMascota;
    private String raza;
    private String nombreMascota;

    public MascotaDTO(){}

    public MascotaDTO(String nombreDuenio, String apellidoDuenio, Long idMascota, String raza, String nombreMascota) {
        this.nombreDuenio = nombreDuenio;
        this.apellidoDuenio = apellidoDuenio;
        this.idMascota = idMascota;
        this.raza = raza;
        this.nombreMascota = nombreMascota;
    }

    public String getNombreDuenio() {
        return nombreDuenio;
    }

    public void setNombreDuenio(String nombreDuenio) {
        this.nombreDuenio = nombreDuenio;
    }

    public String getApellidoDuenio() {
        return apellidoDuenio;
    }

    public void setApellidoDuenio(String apellidoDuenio) {
        this.apellidoDuenio = apellidoDuenio;
    }

    public Long getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(Long idMascota) {
        this.idMascota = idMascota;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    
    
}
