package dev.ellyon.SistemaEscolar.core.entities;

import java.time.LocalDateTime;

public record Telefone(Long id, LocalDateTime createdAt, LocalDateTime updatedAt, String numero) {
}
