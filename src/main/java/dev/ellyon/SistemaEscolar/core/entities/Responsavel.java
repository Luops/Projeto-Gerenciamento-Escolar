package dev.ellyon.SistemaEscolar.core.entities;

import java.time.LocalDateTime;
import java.util.List;

public record Responsavel(Long id, LocalDateTime createdAt, LocalDateTime updatedAt, String nome, String sobrenome, List<Telefone> telefones, String email) {
}
