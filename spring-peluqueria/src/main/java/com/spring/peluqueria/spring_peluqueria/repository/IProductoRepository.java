package com.spring.peluqueria.spring_peluqueria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.peluqueria.spring_peluqueria.model.Producto;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long>{
    
}
