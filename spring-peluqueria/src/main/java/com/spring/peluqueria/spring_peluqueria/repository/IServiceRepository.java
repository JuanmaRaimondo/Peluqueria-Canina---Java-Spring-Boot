package com.spring.peluqueria.spring_peluqueria.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.peluqueria.spring_peluqueria.model.Servicio;


@Repository
public interface IServiceRepository extends JpaRepository<Servicio, Long> {
    
}
