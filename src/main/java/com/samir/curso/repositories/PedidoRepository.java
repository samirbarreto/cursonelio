package com.samir.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.samir.curso.domain.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository <Pedido, Integer>{

}
