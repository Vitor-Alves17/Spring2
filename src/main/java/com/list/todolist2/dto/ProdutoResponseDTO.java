package com.list.todolist2.dto;

import com.list.todolist2.entities.Produto;

public class ProdutoResponseDTO {

    private String nome;
    private double preco;
    private int quantidade;
    private double subValor;

    public ProdutoResponseDTO(Produto produto) {
        this.nome = produto.getNome();
        this.preco = produto.getPreco();
        this.quantidade = produto.getQuantidade();
        this.subValor = preco * quantidade;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }
    public double getSubValor() {
        return subValor;
    }
}
