package com.jaimecorg.springprojects.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jaimecorg.springprojects.tienda.model.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Integer> {
    
}
