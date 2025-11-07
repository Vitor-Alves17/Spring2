package com.list.todolist2.dto;

import com.list.todolist2.entities.Produto;
import jakarta.validation.constraints.*;
import jakarta.validation.constraints.Size;

public class ProdutoRequestDTO {
    @NotBlank(message = "Coloca o nome ai Lyly")
    private String nome;
    @DecimalMin(value = "0.01", inclusive = true)
    private double preco = 0;
    private int quantidade = 0;

    public ProdutoRequestDTO() {
    }
    public ProdutoRequestDTO(Produto produto) {
        this.nome = produto.getNome();
        this.preco = produto.getPreco();
        this.quantidade = produto.getQuantidade();
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
