package com.williambohn.cursomc.service;

import java.util.Optional;

import com.williambohn.cursomc.domain.Pedido;
import com.williambohn.cursomc.repository.PedidoRepository;
import com.williambohn.cursomc.service.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService{

    @Autowired
    private PedidoRepository pedidoRepository;


    public Pedido buscar(Integer id){
        Optional<Pedido> obj = pedidoRepository.findById(id);
        return obj.orElseThrow(() ->  new ObjectNotFoundException(
                                     "Id não encontrado"  + id + "Tipo: " + Pedido.class.getName()));
    }

}
