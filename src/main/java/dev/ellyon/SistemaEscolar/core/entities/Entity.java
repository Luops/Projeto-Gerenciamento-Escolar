package dev.ellyon.SistemaEscolar.core.entities;

import java.time.LocalDateTime;

/**
 * Classe principal que herdará todas as entidades do sistema.
 */
public abstract class Entity {
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    protected Long getId() {
        return this.id;
    }

    protected void setId(Long id) {
        if (id < 0) {
            throw new IllegalArgumentException("Id não pode ser menor que 0");
        }
        this.id = id;
    }

    protected LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    /** Se a data for NULL, uma data atual será criada automáticamente. */
    protected void setCreatedAt(LocalDateTime createdAt) {
        if (createdAt == null) {
            this.createdAt = LocalDateTime.now();
        } else {
            this.createdAt = createdAt;
        }
    }

    protected LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    protected void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

}
