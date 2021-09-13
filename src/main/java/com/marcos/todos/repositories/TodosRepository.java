package com.marcos.todos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.marcos.todos.domain.Todos;

@Repository
public interface TodosRepository extends JpaRepository<Todos, Integer> {

	@Query("SELECT obj FROM Todos obj WHERE obj.finalizado = false ORDER BY obj.dataFinalizar")
	List<Todos> findAllOpen();
	
	@Query("SELECT obj FROM Todos obj WHERE obj.finalizado = true ORDER BY obj.dataFinalizar")

	List<Todos> findAllClose();

}
