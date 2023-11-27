package com.samir.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.samir.curso.domain.Cliente;
import com.samir.curso.dto.ClienteDTO;
import com.samir.curso.repositories.ClienteRepository;
import com.samir.curso.services.exception.DataIntegrityException;
import com.samir.curso.services.exception.ObjectNotFoundException;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repo;
 
	public Cliente find (Integer id){
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", tipo: " + Cliente.class.getName()));
					
		}
	public Cliente update(Cliente obj) {
		Cliente newObj = find(obj.getId());
		updateData(newObj,obj);
		return repo.save(newObj);
	}

	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há entidades relacionadas");
		}
		repo.deleteById(id);
	}

	public List<Cliente> findAll() {
		return repo.findAll();
		}

	public Page<Cliente> findPage(Integer page,Integer linesPerPage, String orderby,String direction){
		PageRequest pageRequest =  PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderby); 
		return repo.findAll(pageRequest);	
	}
	public Cliente fromDTO(ClienteDTO objJDto) {
		return new Cliente(objJDto.getId(), objJDto.getNome(), objJDto.getEmail(), null, null);
		}
	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}


}

	

