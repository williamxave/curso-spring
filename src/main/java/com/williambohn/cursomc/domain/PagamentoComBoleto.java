package com.williambohn.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.williambohn.cursomc.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComBoleto extends Pagamento{
    private static final long serialVersionUID = 1L;

    private Date dataVencimento;
    private Date dataPagamento;

    public PagamentoComBoleto() {
    }
    public PagamentoComBoleto(Integer id, EstadoPagamento estadoPagamento, Pedido pedido, Date dataVencimento,
            Date dataPagamento) {
        super(id, estadoPagamento, pedido);
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }
    public PagamentoComBoleto(Date dataVencimento, Date dataPagamento) {
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }

    public Date getDataVencimento() {
        return this.dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPagamento() {
        return this.dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public PagamentoComBoleto dataVencimento(Date dataVencimento) {
        setDataVencimento(dataVencimento);
        return this;
    }

    public PagamentoComBoleto dataPagamento(Date dataPagamento) {
        setDataPagamento(dataPagamento);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " dataVencimento='" + getDataVencimento() + "'" +
            ", dataPagamento='" + getDataPagamento() + "'" +
            "}";
    }

}
