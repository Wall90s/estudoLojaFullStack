package com.lojaTeste.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lojaTeste.demo.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
