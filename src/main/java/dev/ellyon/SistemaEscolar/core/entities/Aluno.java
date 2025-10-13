package dev.ellyon.SistemaEscolar.core.entities;

import java.time.LocalDateTime;
import java.util.List;

public record Aluno(
        Long id,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        String nome,
        String sobrenome,
        String anoNascimento,
        int idade,
        Turma turma,
        String telefone,
        String email,
        Boletim boletim,
        Endereco endereco,
        List<Responsavel> responsaveis
        /*Faltou matrícula*/
        ) {
}
