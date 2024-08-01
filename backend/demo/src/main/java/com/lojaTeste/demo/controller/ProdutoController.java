package com.lojaTeste.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lojaTeste.demo.model.Produto;
import com.lojaTeste.demo.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
@CrossOrigin("http://localhost:4200/")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<Produto>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getById(@PathVariable Long id) {
        if (produtoService.getById(id) == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Produto> save(@RequestBody Produto produto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.save(produto));
    }

    @PutMapping
    public ResponseEntity<Produto> update(@RequestBody Produto produto) {
        if (produtoService.getById(produto.getId()) == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.save(produto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (produtoService.getById(id) == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        produtoService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
