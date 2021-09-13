package com.marcos.todos.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcos.todos.domain.Todos;
import com.marcos.todos.repositories.TodosRepository;

@Service
public class DBService {

	@Autowired
	private TodosRepository todosRepository;

	public void instanciaBaseDados() throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Todos t1 = new Todos(null, "Estudoar", "Estudar ANgular", sdf.parse("30/03/2022"),
				true);
		Todos t2 = new Todos(null, "Malhar", "Treino peito", sdf.parse("01/12/2021"),
				true);
		Todos t3 = new Todos(null, "Passear", "Passear amora", sdf.parse("30/03/2022"),
				false);

		todosRepository.saveAll(Arrays.asList(t1,t2,t3));

	}

}
