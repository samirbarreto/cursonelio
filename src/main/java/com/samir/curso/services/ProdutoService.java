package com.samir.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.samir.curso.domain.Categoria;
import com.samir.curso.domain.Produto;
import com.samir.curso.repositories.CategoriaRepository;
import com.samir.curso.repositories.ProdutoRepository;
import com.samir.curso.services.exception.ObjectNotFoundException;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository repo;
	@Autowired
	private CategoriaRepository categoriaRepository;
	public Produto find(Integer id) {
		Optional<Produto> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", tipo: " + Categoria.class.getName()));
		
		
	}
	
	public Page<Produto> search(String nome , List<Integer> ids,Integer page,Integer linesPerPage, String orderby,String direction){
		PageRequest pageRequest =  PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderby);  
		List<Categoria> categorias =  categoriaRepository.findAllById(ids);
		return repo.findDistrinctByNomeContainingAndCategoriasIn(nome,categorias,pageRequest);
	
	}
}
