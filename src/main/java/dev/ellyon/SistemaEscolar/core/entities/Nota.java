package dev.ellyon.SistemaEscolar.core.entities;

import java.time.LocalDateTime;

public record Nota(Long id, LocalDateTime createdAt, LocalDateTime updatedAt, Aluno aluno, String materia, Double pontuacao, boolean aprovado) {
}
