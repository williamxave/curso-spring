package com.williambohn.cursomc.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ItemPedidoPk implements Serializable{
    private static final long serialVersionUID = 1L;
    

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;


    public Pedido getPedido() {
        return this.pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return this.produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ItemPedidoPk)) {
            return false;
        }
        ItemPedidoPk itemPedidoPk = (ItemPedidoPk) o;
        return Objects.equals(pedido, itemPedidoPk.pedido) && Objects.equals(produto, itemPedidoPk.produto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pedido, produto);
    }

}
