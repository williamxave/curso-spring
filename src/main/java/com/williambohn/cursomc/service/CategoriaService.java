package com.williambohn.cursomc.service;

import java.util.Optional;

import com.williambohn.cursomc.domain.Categoria;
import com.williambohn.cursomc.repository.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria buscarPorId(Integer id){
        Optional<Categoria> obj = categoriaRepository.findById(id);
        return  obj.orElse(null);
    }
}
