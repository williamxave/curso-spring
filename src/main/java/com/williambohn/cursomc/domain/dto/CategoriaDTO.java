package com.williambohn.cursomc.domain.dto;

import java.io.Serializable;
import java.util.Objects;

import com.williambohn.cursomc.domain.Categoria;

public class CategoriaDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    

    public CategoriaDTO() {
    }

    public CategoriaDTO(Categoria obj) {
    
        this.id = obj.getId();
        this.nome = obj.getNome();

    }


    public CategoriaDTO(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CategoriaDTO id(Integer id) {
        setId(id);
        return this;
    }

    public CategoriaDTO nome(String nome) {
        setNome(nome);
        return this;
    }

}