package dev.ellyon.SistemaEscolar.core.entities;

import java.time.LocalDateTime;

public record Entity(Long id, LocalDateTime createdAt, LocalDateTime updatedAt) {
}
