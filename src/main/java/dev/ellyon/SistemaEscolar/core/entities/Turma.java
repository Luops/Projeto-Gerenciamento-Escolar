package dev.ellyon.SistemaEscolar.core.entities;

import java.time.LocalDateTime;

public record Turma(Long id, LocalDateTime createdAt, LocalDateTime updatedAt, String numero, int qteAlunos, String ano) {
}
