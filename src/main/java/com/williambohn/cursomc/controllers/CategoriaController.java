package com.williambohn.cursomc.controllers;

import java.util.ArrayList;
import java.util.List;

import com.williambohn.cursomc.domain.Categoria;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {
   
    @GetMapping
    public List<Categoria> listar() {
        Categoria cat1 = new Categoria(1, "Infomática");
        Categoria cat2 = new Categoria(2, "Escritório");
        List<Categoria> lista = new ArrayList<>();
        lista.add(cat1);
        lista.add(cat2);
        return lista;
    }
}
