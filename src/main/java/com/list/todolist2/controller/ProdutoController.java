package com.list.todolist2.controller;

import com.list.todolist2.dto.ProdutoRequestDTO;
import com.list.todolist2.dto.ProdutoResponseDTO;
import com.list.todolist2.entities.Produto;
import com.list.todolist2.repository.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping
@CrossOrigin(origins = "*")
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepo;

    @GetMapping(value = "produto")
    public List<ProdutoResponseDTO> getProdutos() {
        List<Produto> produtos = produtoRepo.findAll();
        List<ProdutoResponseDTO> produtosResponseDTO = new ArrayList<>();
        for (Produto produto : produtos) {
            produtosResponseDTO.add(new ProdutoResponseDTO(produto));
        }
        return produtosResponseDTO;
    }
    @GetMapping(value = "produto/{id}")
    public Optional<ProdutoResponseDTO> getProdutos(@PathVariable int id) {
        Optional<Produto> produtos = produtoRepo.findById(id);
        Optional<ProdutoResponseDTO> produtosResponseDTO = produtos.map(ProdutoResponseDTO::new);
        return produtosResponseDTO;
    }

    @PostMapping(value = "produto/cadastrar")
    public ResponseEntity<?> addProduto(@Valid @RequestBody ProdutoRequestDTO produto) {
        Produto prod = new Produto(produto.getNome(), produto.getPreco(), produto.getQuantidade());
        produtoRepo.save(prod);
        return ResponseEntity.ok("Produto adicionado com sucesso");
    }

    @PutMapping("produto/{id}")
    public ResponseEntity<?> updateQuantidade(@PathVariable int id,@RequestBody ProdutoRequestDTO produto) {
        Optional<Produto> ProdutoExiste = produtoRepo.findById(id);
        Optional<ProdutoResponseDTO> ProdutoDTO = ProdutoExiste.map(ProdutoResponseDTO::new);

        if(ProdutoExiste.isPresent()) {
            Produto  prod = ProdutoExiste.get();
            prod.setQuantidade(produto.getQuantidade());
            produtoRepo.save(prod);
            return ResponseEntity.ok("Produto atualizado com sucesso" + " " + ProdutoDTO.toString());
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
