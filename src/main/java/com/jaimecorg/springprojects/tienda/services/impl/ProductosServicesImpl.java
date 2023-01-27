package com.jaimecorg.springprojects.tienda.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jaimecorg.springprojects.tienda.dao.ProductosDAO;
import com.jaimecorg.springprojects.tienda.model.Producto;
import com.jaimecorg.springprojects.tienda.services.ProductosServices;

@Service
public class ProductosServicesImpl implements ProductosServices {

    @Autowired
    ProductosDAO productosDAO;

    @Override
    public Page<Producto> findAll(Pageable page) {        
        
        return productosDAO.findAll(page);
    }

    @Override
    public Producto findProducto(int codigo) {        
        
        return productosDAO.findProducto(codigo);
    }

    @Override
    public void insert(Producto producto) {
        productosDAO.insert(producto);
    }

    @Override
    public void update(Producto producto) {
        productosDAO.update(producto);

        if (producto.getImg() != null && producto.getImg().length > 0) {
            productosDAO.updateImg(producto);
        } 
    }

    @Override
    public void delete(int codigo) {
        productosDAO.delete(codigo);
    }
    

}
