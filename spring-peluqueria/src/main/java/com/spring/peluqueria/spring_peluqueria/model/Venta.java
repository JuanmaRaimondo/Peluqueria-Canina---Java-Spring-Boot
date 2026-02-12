package com.spring.peluqueria.spring_peluqueria.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private LocalDate fechaVenta;
    
    private Double costoTotal;

    @ManyToMany
    private List<Producto> listaProducto;
    public Venta(){}

   

    public Venta(Long id, LocalDate fechaVenta, List<Producto> listaProducto, Double costoTotal) {
        this.id = id;
        this.fechaVenta = fechaVenta;
        this.listaProducto = listaProducto;
        this.costoTotal = costoTotal;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public List<Producto> getListaProducto() {
        return listaProducto;
    }

    public void setListaProducto(List<Producto> listaProducto) {
        this.listaProducto = listaProducto;
    }

    public Double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(Double costoTotal) {
        this.costoTotal = costoTotal;
    }

    
}
