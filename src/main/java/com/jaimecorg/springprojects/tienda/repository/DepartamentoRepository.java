package com.jaimecorg.springprojects.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jaimecorg.springprojects.tienda.model.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Integer>{
    
}
