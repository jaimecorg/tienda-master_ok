package com.jaimecorg.springprojects.tienda.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jaimecorg.springprojects.tienda.model.Producto;

public interface ProductosServices {
    
    public Page<Producto> findAll(Pageable page);

    public Producto findProducto(int codigo);

    public void insert(Producto producto);

    public void update(Producto producto);

    public void delete(int codigo);
}
