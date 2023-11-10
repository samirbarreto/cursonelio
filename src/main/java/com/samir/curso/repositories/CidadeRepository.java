package com.samir.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.samir.curso.domain.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository <Cidade, Integer>{

}
