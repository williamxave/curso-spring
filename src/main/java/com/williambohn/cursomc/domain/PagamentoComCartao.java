package com.williambohn.cursomc.domain;

import javax.persistence.Entity;

import com.williambohn.cursomc.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComCartao extends Pagamento{
    private static final long serialVersionUID = 1L;

    private Integer numeroDeparcelas;

    public PagamentoComCartao() {
    }

    public PagamentoComCartao( Integer id,Integer numeroDeparcelas, 
                                        EstadoPagamento estadoPagamento, Pedido pedido) {

        super(id, estadoPagamento, pedido);
        this.numeroDeparcelas = numeroDeparcelas;
    }

    public Integer getNumeroDeparcelas() {
        return this.numeroDeparcelas;
    }

    public void setNumeroDeparcelas(Integer numeroDeparcelas) {
        this.numeroDeparcelas = numeroDeparcelas;
    }


}
