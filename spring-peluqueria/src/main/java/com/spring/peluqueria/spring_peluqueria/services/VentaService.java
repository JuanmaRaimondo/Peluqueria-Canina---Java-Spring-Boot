package com.spring.peluqueria.spring_peluqueria.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.peluqueria.spring_peluqueria.model.Duenio;
import com.spring.peluqueria.spring_peluqueria.model.Producto;
import com.spring.peluqueria.spring_peluqueria.model.Servicio;
import com.spring.peluqueria.spring_peluqueria.model.Venta;
import com.spring.peluqueria.spring_peluqueria.repository.IDuenioRepository;
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

    public void crearVenta(Venta venta){

        if (venta.getListaProducto() == null) {
            venta.setListaProducto(new ArrayList<>());
        }

        Double total = 0.0;
        List<Producto> productosParaGuardar = new ArrayList<>();
        List<Servicio> servicioParaGuardar = new ArrayList<>();

        // 1. Obtener el dueño "vacío" que viene del JSON (solo trae ID)
        Duenio duenioDelJson = venta.getDuenio();

        // 2. Buscar el dueño real en la base de datos
        // (Usamos el repositorio que acabamos de inyectar)
        Duenio duenioReal = duenioRepo.findById(duenioDelJson.getId()).orElse(null);

        // 3. Asignar el dueño real a la venta
        venta.setDuenio(duenioReal);


        for (Producto p : venta.getListaProducto()) {

           Producto productoReal = productorepo.findById(p.getId()).orElse(null);
            
            if (productoReal != null) {
                // B. Calculamos el precio y sumamos al total
                total += productoReal.getPrecioVenta();
                
                // C. Restamos Stock (¡Lógica de negocio!)
                productoReal.setStock(productoReal.getStock() - 1);
                
                // D. Guardamos el producto actualizado (con menos stock) en la BD
                productorepo.save(productoReal);
                
                // E. Agregamos el producto real a nuestra lista temporal
                productosParaGuardar.add(productoReal);
            }
        }

        for (Servicio s : venta.getListaServicio()) {
            Servicio servicioReal = servicerepo.findById(s.getId()).orElse(null);

            if(servicioReal != null){
                if(servicioReal.getPrecio() != null){
                    total += servicioReal.getPrecio();
                }
                servicioParaGuardar.add(servicioReal);
            }
        }

        // 4. Asignamos los datos finales a la Venta
        venta.setListaProducto(productosParaGuardar); 
        venta.setListaServicio(servicioParaGuardar);// Relacionamos los productos reales
        venta.setCostoTotal(total); // Guardamos cuánto costó todo
        venta.setFechaVenta(java.time.LocalDate.now()); // Ponemos la fecha de hoy automáticamente

        // 5. ¡Guardamos el Ticket final!
        ventarepo.save(venta);
        }

        public List<Venta> traerVentas(){
            return ventarepo.findAll();
        }
    }

