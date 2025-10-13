package dev.ellyon.SistemaEscolar.core.entities;

import java.time.LocalDateTime;
import java.util.List;

public record Boletim(Long id, LocalDateTime createdAt, LocalDateTime updatedAt, Aluno aluno, List<Nota> notas, boolean aprovado) {
}
