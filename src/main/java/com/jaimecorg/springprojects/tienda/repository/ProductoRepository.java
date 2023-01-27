package com.jaimecorg.springprojects.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jaimecorg.springprojects.tienda.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    
}
