package com.jaimecorg.springprojects.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jaimecorg.springprojects.tienda.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    
}
