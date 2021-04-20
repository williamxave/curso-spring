package com.williambohn.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Produto implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String nome;
    private Double preco;

    @JsonBackReference // ele vai omitir a lista de categoria para cada produto, pq ja foi puxado isso na categoria
    @ManyToMany // Vai Criar a table de relacionamento N:N, do outro lado é mapear
    @JoinTable(name ="PRODUTO_CATEGORIA",
     joinColumns = @JoinColumn(name = "produto_fk"),
     inverseJoinColumns = @JoinColumn(name = "categoria_fk")
    )
    private List<Categoria> categorias = new ArrayList();

    public Produto() {
    }

    public Produto(Integer id, String nome, Double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
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

    public Double getPreco() {
        return this.preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Produto id(Integer id) {
        setId(id);
        return this;
    }

    public Produto nome(String nome) {
        setNome(nome);
        return this;
    }

    public Produto preco(Double preco) {
        setPreco(preco);
        return this;
    }
    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Produto)) {
            return false;
        }
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nome='" + getNome() + "'" +
            ", preco='" + getPreco() + "'" +
            "}";
    }


}
