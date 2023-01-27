package com.jaimecorg.springprojects.tienda.dao;

import java.util.List;

import com.jaimecorg.springprojects.tienda.model.DetallePedido;
import com.jaimecorg.springprojects.tienda.model.Pedido;

public interface DetallePedidosDAO {
    
    public void insert(Pedido pedido, DetallePedido detallePedido);

    public List<DetallePedido> findDetalle(Pedido pedido);

    public void delete(Pedido pedido);

}