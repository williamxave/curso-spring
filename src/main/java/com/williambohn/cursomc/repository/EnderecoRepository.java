package com.williambohn.cursomc.repository;

import java.util.List;

import com.williambohn.cursomc.domain.Endereco;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository  extends JpaRepository<Endereco, Integer>{

    
}
