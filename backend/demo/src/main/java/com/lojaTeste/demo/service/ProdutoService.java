package com.lojaTeste.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lojaTeste.demo.model.Produto;
import com.lojaTeste.demo.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public List<Produto> getAll(){
        return produtoRepository.findAll();
    }

    public Produto getById(Long id){
        Optional<Produto> produtoOptional = produtoRepository.findById(id);

        if (produtoOptional.isPresent()) {
            Produto produto = produtoOptional.get();
            return produto;
        }
        return null;
    }

    public Produto save(Produto novoProduto){
        return produtoRepository.save(novoProduto);
    }

    public void delete(Long id){
        produtoRepository.deleteById(id);
    }
}
