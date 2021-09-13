package com.marcos.todos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcos.todos.domain.Todos;
import com.marcos.todos.repositories.TodosRepository;

@Service
public class TodoService {

	@Autowired
	private TodosRepository repository;
	
	public Todos findById(Integer id) {
		Optional<Todos> obj = repository.findById(id);
		return obj.orElse(null);
	}

	public List<Todos> findAllOpen() {
		List<Todos> list = repository.findAllOpen();
		return list;
	}

	public List<Todos> findAllClose() {
		List<Todos> list = repository.findAllClose();
		return list;
	}

	public List<Todos> findAll() {
		List<Todos> list = repository.findAll();
		return list;
		}

	public Todos create(Todos obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
		
	}

	public Todos update(Integer id, Todos obj) {
		Todos newObj = findById(id);
		newObj.setTitulo(obj.getTitulo());
		newObj.setDataFinalizar(obj.getDataFinalizar());
		newObj.setDescricao(obj.getDescricao());
		newObj.setFinalizado(obj.getFinalizado());
		return repository.save(newObj);
	}
	
}
