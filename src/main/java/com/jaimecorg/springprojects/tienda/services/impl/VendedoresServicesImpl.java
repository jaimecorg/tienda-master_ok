package com.jaimecorg.springprojects.tienda.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jaimecorg.springprojects.tienda.model.Vendedor;
import com.jaimecorg.springprojects.tienda.repository.VendedorRepository;
import com.jaimecorg.springprojects.tienda.services.VendedoresService;

@Service
public class VendedoresServicesImpl implements VendedoresService{

    @Autowired
    VendedorRepository repository;

    @Override
    public Page<Vendedor> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Vendedor find(int codigo) {
        Optional<Vendedor> findById = repository.findById(codigo);
        if(findById != null){
            return findById.get();
        } 
        return null;       
    }

    @Override
    public void save(Vendedor vendedor) {
        repository.save(vendedor);
    }

    @Override
    public void update(Vendedor vendedor) {
        repository.save(vendedor);        
    }

    @Override
    public void delete(int codigo) {
        repository.deleteById(codigo);        
    }
    
}