package dev.ellyon.SistemaEscolar.core.entities;

import java.time.LocalDateTime;
import java.util.List;

public record Professor(Long id, LocalDateTime createdAt, LocalDateTime updatedAt, String nome, String sobrenome, List<String> materias, int totalAlunos, List<Turma> turmas) {
}
