package br.com.gustavo.todolist.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TodoDto(@NotBlank String nome, @NotBlank String descricao, @NotNull int prioridade) {
    
}
