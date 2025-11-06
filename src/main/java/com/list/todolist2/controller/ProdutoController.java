package com.list.todolist2.controller;

import com.list.todolist2.dto.ProdutoRequestDTO;
import com.list.todolist2.entities.Produto;
import com.list.todolist2.repository.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
@CrossOrigin(origins = "*")
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepo;

    @GetMapping(value = "produto")
    public List<Produto> getProdutos() {
        return produtoRepo.findAll();
    }
    @GetMapping(value = "produto/{id}")
    public Optional<Produto> getProdutos(@PathVariable int id) {
        return produtoRepo.findById(id);
    }

    @PostMapping(value = "produto/cadastrar")
    public ResponseEntity<?> addProduto(@Valid @RequestBody ProdutoRequestDTO produto) {
        Produto prod = new Produto(produto.getNome(), produto.getPreco(), produto.getQuantidade());
        produtoRepo.save(prod);
        return ResponseEntity.ok("Produto adicionado com sucesso");
    }

    @PutMapping("produto/{id}")
    public ResponseEntity<?> updateQuantidade(@PathVariable int id,@RequestBody Produto produto) {
        Optional<Produto> ProdutoExiste = produtoRepo.findById(id);

        if(ProdutoExiste.isPresent()) {
            Produto  prod = ProdutoExiste.get();
            prod.setQuantidade(produto.getQuantidade());
            produtoRepo.save(prod);
            return ResponseEntity.ok("Produto atualizado com sucesso" + " " + ProdutoExiste.toString());
        } else  {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("produto/{id}")
    public ResponseEntity<?> deleteProduto(@PathVariable int id) {
        if(produtoRepo.existsById(id)) {
            produtoRepo.deleteById(id);
            return ResponseEntity.ok("Produto removido com sucesso");
        } else   {
            return ResponseEntity.ok("Produto não encontrado, ou já deletado");
        }
    }
}
