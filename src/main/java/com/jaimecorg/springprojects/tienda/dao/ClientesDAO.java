package com.jaimecorg.springprojects.tienda.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jaimecorg.springprojects.tienda.model.Cliente;

public interface ClientesDAO {
    // public List<Cliente> findAll();

    public Page<Cliente> findAll(Pageable page);

    public Cliente findCliente(int codigo);

    public void insert(Cliente cliente);

    public void update(Cliente cliente);

    public void delete(int codigo);
}
