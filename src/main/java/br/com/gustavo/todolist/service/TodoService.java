package br.com.gustavo.todolist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.gustavo.todolist.models.Mensagem;
import br.com.gustavo.todolist.models.TodoModel;
import br.com.gustavo.todolist.repository.TodoRepository;

@Service
public class TodoService {
    
    private Mensagem mensagem;
    private TodoRepository acao;

    public TodoService(Mensagem mensagem, TodoRepository acao) {
        this.mensagem = mensagem;
        this.acao = acao;
    }

    // Método para cadastrar tarefas
    public ResponseEntity<?> cadastrar(TodoModel obj){

        if(obj.getNome().isEmpty()){
            mensagem.setMensagem("A tarefa precisa ser preenchida");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } 
        else if(obj.getDescricao().equals("")){
            mensagem.setMensagem("A descrição precisa ser preenchida");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } 
        else if (obj.getPrioridade() <= 0) {
            mensagem.setMensagem("Nivel de prioridade deve ser preenchdio");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }  
        else{
            return new ResponseEntity<>(acao.save(obj), HttpStatus.OK);
        }   
         
    }

    // Método para selecionar as tarefas
    public ResponseEntity<List<TodoModel>> selecionar(){
        List<TodoModel> tarefas = acao.findAll();
        return new ResponseEntity<>(tarefas, HttpStatus.OK);
    }

    //Método para selecionar um aluno pelo ID e incluir a média
    public ResponseEntity<TodoModel> selecionarPeloId(Long id) {
        Optional<TodoModel> tarefa = acao.findById(id);
        if (tarefa.isEmpty()) {
            mensagem.setMensagem("Não foi encontrado nenhum aluno com esse id");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            TodoModel todo = tarefa.get();
            return new ResponseEntity<>(todo, HttpStatus.OK);
        
    }
    
}

    // Método para editar dados

    public ResponseEntity<?> editar(TodoModel obj){
        if(!acao.existsById(obj.getId())){
            mensagem.setMensagem("Id informado não existe");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else if (obj.getNome().isEmpty()) {
            mensagem.setMensagem("Nome informado deve ser prenchiddo");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else if(obj.getDescricao().isEmpty()){
            mensagem.setMensagem("A descrição precisa ser preenchida");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else if(obj.getPrioridade() <= 0){
            mensagem.setMensagem("Nivel de prioridade deve ser preenchdio");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else{
            return new ResponseEntity<>(acao.save(obj), HttpStatus.OK);
        }
    }

    // Método para remover registros
    public ResponseEntity<?> remover(Long id){
        if (acao.countById(id) == 0) {
            mensagem.setMensagem("Id informado não existe");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else{
            TodoModel obj = acao.findById(id).orElse(null);
            acao.delete(obj);
        }
        mensagem.setMensagem("Tarefa removda com sucesso");
        return new ResponseEntity<>(mensagem, HttpStatus.OK);
    }

    //Método atualizar status da tarefa
    public ResponseEntity<?> atualizarStatus(Long id, boolean realizado){
        if (!acao.existsById(id)) {
            mensagem.setMensagem("Id informado não existe");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else{
            TodoModel obj = acao.findById(id).orElse(null);
            obj.setRealizado(realizado);
            acao.save(obj);
            mensagem.setMensagem("Status da tarefa realizado com sucesso!");
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        }
    }
}
