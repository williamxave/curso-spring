package com.williambohn.cursomc.service;

import java.util.Optional;

import com.williambohn.cursomc.domain.Cliente;
import com.williambohn.cursomc.repository.ClienteRepository;
import com.williambohn.cursomc.service.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente find(Integer id){
        Optional<Cliente> obj = clienteRepository.findById(id);
        return obj.orElseThrow(() -> new  ObjectNotFoundException(
                                    "Objeto não encontrado " + id + "Tipo: " +Cliente.class.getName()));
    }
}


