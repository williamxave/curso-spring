package com.williambohn.cursomc.controller;

import java.util.Optional;

import com.williambohn.cursomc.domain.Cliente;
import com.williambohn.cursomc.service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> findClientId(@PathVariable Integer id){
        Cliente obj =  clienteService.find(id);
        return ResponseEntity.ok().body(obj);
    }
}
