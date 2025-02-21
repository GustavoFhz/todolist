package br.com.gustavo.todolist.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import br.com.gustavo.todolist.models.TodoModel;
import br.com.gustavo.todolist.service.TodoService;
import jakarta.validation.Valid;

@RestController
public class TodoController {
    
   
    private TodoService todoService;

    public TodoController( TodoService todoService) {
        
        this.todoService = todoService;
    }

    //Cadastrar tarefa
    @PostMapping("/api/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody @Valid TodoModel obj){
        return todoService.cadastrar(obj);
    }


    //Selecionar tarefas
    @GetMapping("/api/selecionar")
    ResponseEntity<List<TodoModel>> selecionarTarefas(){
        return todoService.selecionar();
    }

    //Selecionar tarefa pelo id
    @GetMapping("/api/{id}/selecionar")
    public ResponseEntity<?> selecionarPeloId(@PathVariable Long id){
        return todoService.selecionarPeloId(id);
    }


    //Editar tarefa
    @PutMapping("/api/editar")
    public ResponseEntity<?> editar(@RequestBody TodoModel obj){
        return todoService.editar(obj);
    }

    //Remover tarefa
    @DeleteMapping("/api/{id}")
        public ResponseEntity<?> remover(@PathVariable Long id){
            return todoService.remover(id);
    }
    
    // Status da tarefa
    @PatchMapping("/api/{id}/status")
    public ResponseEntity<?> atualizarStatus(@PathVariable Long id, @RequestParam boolean realizado) {
    return todoService.atualizarStatus(id, realizado);
}

    
}
