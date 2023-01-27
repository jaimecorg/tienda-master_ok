package com.jaimecorg.springprojects.tienda.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jaimecorg.springprojects.tienda.model.Cliente;
import com.jaimecorg.springprojects.tienda.repository.ClienteRepository;
import com.jaimecorg.springprojects.tienda.services.ClientesServices;

@Service
public class ClientesServicesImpl implements ClientesServices {

    @Autowired
    ClienteRepository repository;

    @Override
    public Page<Cliente> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Cliente findCliente(int codigo) {
        Optional<Cliente> findById = repository.findById(codigo);
        if(findById != null){
            return findById.get();
        } 
        return null;       
    }

    @Override
    public void save(Cliente cliente) {
        repository.save(cliente);
    }

    @Override
    public void update(Cliente cliente) {
        repository.save(cliente);        
    }

    @Override
    public void delete(int codigo) {
        repository.deleteById(codigo);        
    }

    @Override
    public void insert(Cliente cliente) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Cliente findAll(int codigo) {
        // TODO Auto-generated method stub
        return null;
    }

}
