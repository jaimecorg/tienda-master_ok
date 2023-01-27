package com.jaimecorg.springprojects.tienda.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jaimecorg.springprojects.tienda.model.Cliente;

public interface ClientesServices {
    
    public Page<Cliente> findAll(Pageable page);

    public Cliente findCliente(int codigo);

    //public void insert(Cliente cliente);
    public void save(Cliente cliente);
    public void update(Cliente cliente);

    public void delete(int codigo);

    public void insert(Cliente cliente);

    public Cliente findAll(int codigo);
}
