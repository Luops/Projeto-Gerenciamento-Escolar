package dev.ellyon.SistemaEscolar.core.entities;

import java.time.LocalDateTime;

public record Endereco(Long id, LocalDateTime createdAt, LocalDateTime updatedAt, String rua, String numero, String complemento, String bairro, String cidade, String estado, String cep) {
}
