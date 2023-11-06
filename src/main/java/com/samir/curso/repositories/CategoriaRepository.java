package com.samir.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.samir.curso.domain.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository <Categoria, Integer>{

}
