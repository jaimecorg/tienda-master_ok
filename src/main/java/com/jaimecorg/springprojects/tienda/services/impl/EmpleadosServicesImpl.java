package com.jaimecorg.springprojects.tienda.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaimecorg.springprojects.tienda.model.Empleado;
import com.jaimecorg.springprojects.tienda.repository.EmpleadoRepository;
import com.jaimecorg.springprojects.tienda.services.EmpleadosServices;

@Service
public class EmpleadosServicesImpl implements EmpleadosServices {

    @Autowired
    EmpleadoRepository repository;
    @Override
    public Empleado findEmpleado(int codigo) {
        Optional<Empleado> findById = repository.findById(codigo);
        if(findById != null){
            return findById.get();
        } 
        return null;       
    }

    @Override
    public void save(Empleado empleado) {
        repository.save(empleado);
    }

    @Override
    public void update(Empleado empleado) {
        repository.save(empleado);        
    }

    @Override
    public void delete(int codigo) {
        repository.deleteById(codigo);        
    }

    @Override
    public void insert(Empleado empleado) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Empleado findAll(int codigo) {
        // TODO Auto-generated method stub
        return null;
    }

}
