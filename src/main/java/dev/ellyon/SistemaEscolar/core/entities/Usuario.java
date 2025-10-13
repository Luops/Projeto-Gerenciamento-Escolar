package dev.ellyon.SistemaEscolar.core.entities;

import java.time.LocalDateTime;

public record Usuario(Long id, LocalDateTime createdAt, LocalDateTime updatedAt, String email, String senha, Long entidadeId, String role) {
}
