package com.jaimecorg.springprojects.tienda.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jaimecorg.springprojects.tienda.model.Vendedor;


public interface VendedoresService {
    public Page<Vendedor> findAll(Pageable page);
    public Vendedor find(int codigo);
    public void save(Vendedor producto);
    public void update(Vendedor producto);
    public void delete(int codigo);
}