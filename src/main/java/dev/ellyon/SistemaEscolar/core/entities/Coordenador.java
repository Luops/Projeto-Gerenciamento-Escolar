package dev.ellyon.SistemaEscolar.core.entities;

import java.time.LocalDateTime;

public record Coordenador(Long id, LocalDateTime createdAt, LocalDateTime updatedAt, String nome, String sobrenome) {
}
