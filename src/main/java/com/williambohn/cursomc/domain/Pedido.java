package com.williambohn.cursomc.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Pedido  implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date instanteDoPedido;

    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
    private Pagamento pagamento;

    
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "endereco_de_entrega_id")
    private Endereco enderecoDeEntrega;

    @OneToMany(mappedBy = "id.pedido")
    private Set<ItemPedido> itens = new HashSet<>();

    public Pedido() {
    }

    public Pedido(Integer id, Date instanteDoPedido, Cliente cliente, Endereco enderecoDeEntrega) {
        this.id = id;
        this.instanteDoPedido = instanteDoPedido;
        this.cliente = cliente;
        this.enderecoDeEntrega = enderecoDeEntrega;
    }

    public Set<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(Set<ItemPedido> itens) {
        this.itens = itens;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getInstanteDoPedido() {
        return this.instanteDoPedido;
    }

    public void setInstanteDoPedido(Date instanteDoPedido) {
        this.instanteDoPedido = instanteDoPedido;
    }

    public Pagamento getPagamento() {
        return this.pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Endereco getEnderecoDeEntrega() {
        return this.enderecoDeEntrega;
    }

    public void setEnderecoDeEntrega(Endereco enderecoDeEntrega) {
        this.enderecoDeEntrega = enderecoDeEntrega;
    }

    public Pedido id(Integer id) {
        setId(id);
        return this;
    }

    public Pedido instanteDoPedido(Date instanteDoPedido) {
        setInstanteDoPedido(instanteDoPedido);
        return this;
    }

    public Pedido pagamento(Pagamento pagamento) {
        setPagamento(pagamento);
        return this;
    }

    public Pedido cliente(Cliente cliente) {
        setCliente(cliente);
        return this;
    }

    public Pedido enderecoDeEntrega(Endereco enderecoDeEntrega) {
        setEnderecoDeEntrega(enderecoDeEntrega);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pedido)) {
            return false;
        }
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", instanteDoPedido='" + getInstanteDoPedido() + "'" +
            ", pagamento='" + getPagamento() + "'" +
            ", cliente='" + getCliente() + "'" +
            ", enderecoDeEntrega='" + getEnderecoDeEntrega() + "'" +
            "}";
    }
    
}
