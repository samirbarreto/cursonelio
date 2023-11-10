package com.samir.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.samir.curso.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository <Cliente, Integer>{

}
