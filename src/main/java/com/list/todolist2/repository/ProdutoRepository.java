package com.list.todolist2.repository;

import com.list.todolist2.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    public Produto findByNome(String nome);
    public double getPreco();
    public int getQuantidade();
}
