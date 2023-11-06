package com.samir.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.samir.curso.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository <Produto, Integer>{

}
