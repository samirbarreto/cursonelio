package com.samir.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.samir.curso.domain.Categoria;
import com.samir.curso.repositories.CategoriaRepository;
import com.samir.curso.services.exception.DataIntegrityException;
import com.samir.curso.services.exception.ObjectNotFoundException;

@Service
public class CategoriaService {
	private static final String Throw = null;
	@Autowired
	private CategoriaRepository repo;

	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", tipo: " + Categoria.class.getName()));

	}

	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos");
		}
		repo.deleteById(id);
	}

	public List<Categoria> findAll() {
		return repo.findAll();
		}

	public Page<Categoria> findPage(Integer page,Integer linesPerPage, String orderby,String direction){
		PageRequest pageRequest =  PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderby); 
		return repo.findAll(pageRequest);	
	}

}
