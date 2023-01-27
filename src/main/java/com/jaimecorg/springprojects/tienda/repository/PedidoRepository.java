package com.jaimecorg.springprojects.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jaimecorg.springprojects.tienda.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    
}
