package com.spring.peluqueria.spring_peluqueria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.spring.peluqueria.spring_peluqueria.model.Producto;
import com.spring.peluqueria.spring_peluqueria.repository.IProductoRepository;

@Service
public class ProductoService {
    
    @Autowired
    private IProductoRepository productorepo;

    public void crearProducto(Producto producto){
        productorepo.save(producto);
    }

    public Producto encontrarProducto(Long id_producto){
        
    Producto   productoEncontrado = productorepo.findById(id_producto).orElse(null);

    return productoEncontrado;

    }

    public List<Producto> listarProductos(){
        return productorepo.findAll();
    }

    public void borrarProducto(Long id_producto){
        productorepo.findById(id_producto).orElse(null);
        productorepo.deleteById(id_producto);
    }

    public void editarProducto(Long id_producto, Producto producto){
        Producto productoEncontrado = productorepo.findById(id_producto).orElse(null);
        if(productoEncontrado != null){
            productoEncontrado.setNombre(producto.getNombre());
            productoEncontrado.setCosto(producto.getCosto());
            productoEncontrado.setMarca(producto.getMarca());
            productoEncontrado.setPrecioVenta(producto.getPrecioVenta());
            productoEncontrado.setStock(producto.getStock());
            productorepo.save(productoEncontrado);
        }
    }
}
