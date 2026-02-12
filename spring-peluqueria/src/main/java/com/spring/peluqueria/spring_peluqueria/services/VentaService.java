package com.spring.peluqueria.spring_peluqueria.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.peluqueria.spring_peluqueria.model.Producto;
import com.spring.peluqueria.spring_peluqueria.model.Venta;
import com.spring.peluqueria.spring_peluqueria.repository.IProductoRepository;
import com.spring.peluqueria.spring_peluqueria.repository.IVentaRepository;

@Service
public class VentaService {
    
    @Autowired
    private IVentaRepository ventarepo;

    @Autowired
    private IProductoRepository productorepo;

    public void crearVenta(Venta venta){

        Double total = 0.0;
        List<Producto> productosParaGuardar = new ArrayList<>();
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

        // 4. Asignamos los datos finales a la Venta
        venta.setListaProducto(productosParaGuardar); // Relacionamos los productos reales
        venta.setCostoTotal(total); // Guardamos cuánto costó todo
        venta.setFechaVenta(java.time.LocalDate.now()); // Ponemos la fecha de hoy automáticamente

        // 5. ¡Guardamos el Ticket final!
        ventarepo.save(venta);
        }

        public List<Venta> traerventas(){
            return ventarepo.findAll();
        }
    }

