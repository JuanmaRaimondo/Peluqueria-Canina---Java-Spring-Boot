package com.spring.peluqueria.spring_peluqueria.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.peluqueria.spring_peluqueria.model.Duenio;
import com.spring.peluqueria.spring_peluqueria.model.Mascota;
import com.spring.peluqueria.spring_peluqueria.model.Producto;
import com.spring.peluqueria.spring_peluqueria.model.Servicio;
import com.spring.peluqueria.spring_peluqueria.model.Venta;
import com.spring.peluqueria.spring_peluqueria.repository.IDuenioRepository;
import com.spring.peluqueria.spring_peluqueria.repository.IMascotaRepository;
import com.spring.peluqueria.spring_peluqueria.repository.IProductoRepository;
import com.spring.peluqueria.spring_peluqueria.repository.IServiceRepository;
import com.spring.peluqueria.spring_peluqueria.repository.IVentaRepository;

@Service
public class VentaService {
    
    @Autowired
    private IVentaRepository ventarepo;

    @Autowired
    private IProductoRepository productorepo;

    @Autowired
    private IDuenioRepository duenioRepo;

    @Autowired
    private IServiceRepository servicerepo;

    @Autowired
    private IMascotaRepository mascotaRepo;

  public void crearVenta(Venta venta) {

        Double total = 0.0;
        List<Producto> productosParaGuardar = new ArrayList<>();
        List<Servicio> servicioParaGuardar = new ArrayList<>();

        // ---------------------------------------------------
        // 1. DUEÑO
        // ---------------------------------------------------
        Duenio duenioDelJson = venta.getDuenio();
        // Aseguramos que el objeto duenio no sea null para evitar NullPointerException
        if (duenioDelJson != null && duenioDelJson.getId() != null) {
             Duenio duenioReal = duenioRepo.findById(duenioDelJson.getId()).orElse(null);
             venta.setDuenio(duenioReal);
        }

        // ---------------------------------------------------
        // 2. MASCOTA (Aquí estaba el error de llaves)
        // ---------------------------------------------------
        if (venta.getMascota() != null && venta.getMascota().getId() != null) {
            Mascota mascotaReal = mascotaRepo.findById(venta.getMascota().getId()).orElse(null);
            if (mascotaReal != null) {
                venta.setMascota(mascotaReal);
            }
        } // <--- ¡AQUÍ CERRAMOS LA LÓGICA DE MASCOTA!

        // ---------------------------------------------------
        // 3. PRODUCTOS
        // ---------------------------------------------------
        if (venta.getListaProducto() == null) {
            venta.setListaProducto(new ArrayList<>());
        }

        for (Producto p : venta.getListaProducto()) {
            Producto productoReal = productorepo.findById(p.getId()).orElse(null);

            if (productoReal != null) {
                total += productoReal.getPrecioVenta();
                
                // Restar Stock
                if (productoReal.getStock() > 0) {
                     productoReal.setStock(productoReal.getStock() - 1);
                     productorepo.save(productoReal);
                     productosParaGuardar.add(productoReal);
                }
            }
        }

        // ---------------------------------------------------
        // 4. SERVICIOS
        // ---------------------------------------------------
        // Casco de seguridad
        if (venta.getListaServicio() == null) {
            venta.setListaServicio(new ArrayList<>());
        }

        for (Servicio s : venta.getListaServicio()) {
            Servicio servicioReal = servicerepo.findById(s.getId()).orElse(null); // Ojo: servicerepo vs servicioRepo

            if (servicioReal != null) {
                if (servicioReal.getPrecio() != null) {
                    total += servicioReal.getPrecio();
                }
                servicioParaGuardar.add(servicioReal);
            }
        }

        // ---------------------------------------------------
        // 5. GUARDADO FINAL
        // ---------------------------------------------------
        venta.setListaProducto(productosParaGuardar);
        venta.setListaServicio(servicioParaGuardar);
        venta.setCostoTotal(total);
        venta.setFechaVenta(java.time.LocalDate.now());

        ventarepo.save(venta);
    }

        public List<Venta> traerVentas(){
            return ventarepo.findAll();
        }
    }

