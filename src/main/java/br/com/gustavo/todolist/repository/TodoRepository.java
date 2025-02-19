package br.com.gustavo.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gustavo.todolist.models.TodoModel;

public interface TodoRepository extends JpaRepository<TodoModel, Long> {
    
    Long countById(Long id);
}
