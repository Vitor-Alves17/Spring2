package com.list.todolist2.dto;

import jakarta.validation.constraints.NotBlank;

public class ProdutoRequestDTO {
    @NotBlank(message = "Coloca o nome ai Lyly")
    private String nome;
    @NotBlank(message = "Coloca o nome ai Lyly")
    private double preco = 0;
    @NotBlank(message = "Coloca o nome ai Lyly")
    private int quantidade = 0;

    public ProdutoRequestDTO() {
    }
    public ProdutoRequestDTO(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
