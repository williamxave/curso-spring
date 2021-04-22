package com.williambohn.cursomc.repository;

import com.williambohn.cursomc.domain.Pagamento;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
    
}
