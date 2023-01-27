package com.jaimecorg.springprojects.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jaimecorg.springprojects.tienda.model.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer>{
    
}
