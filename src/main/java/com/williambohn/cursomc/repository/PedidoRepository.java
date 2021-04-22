package com.williambohn.cursomc.repository;

import com.williambohn.cursomc.domain.Pedido;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
    
}
