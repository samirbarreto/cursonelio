package com.samir.curso.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samir.curso.domain.Categoria;
import com.samir.curso.repositories.CategoriaRepository;
import com.samir.curso.services.exception.ObjectNotFoundException;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository repo;
 
	public Categoria buscar (Integer id){
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", tipo: " + Categoria.class.getName()));
					
		}
	}

