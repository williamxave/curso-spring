package com.williambohn.cursomc.service;

import java.util.Optional;

import com.williambohn.cursomc.domain.Categoria;
import com.williambohn.cursomc.repository.CategoriaRepository;
import com.williambohn.cursomc.service.exceptions.DataIntegrityException;
import com.williambohn.cursomc.service.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria find(Integer id){
        Optional<Categoria> obj = categoriaRepository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException(
                                    "Objeto não encontrado! Id: "+ id + ",Tipo: " +Categoria.class.getName()));
    }

    public Categoria insert (Categoria categoria){
        categoria.setId(null);
        return categoriaRepository.save(categoria);
    }

    public Categoria update(Categoria categoria){
        find(categoria.getId());
        return categoriaRepository.save(categoria);
    }

    public void deletar(Integer id){
        find(id);
        try{
            categoriaRepository.deleteById(id);
        }catch(DataIntegrityViolationException e){

            throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos");
           
        }
       
    }

   
}
