package dev.ellyon.SistemaEscolar.core.entities;

import java.time.LocalDateTime;

/**
 * Classe principal que herdará todas as entidades do sistema.
 */
public abstract class Entidade {
    private Long id;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;
/*
    protected Long getId() {
        return this.id;
    }

    protected void setId(Long id) {
        if (id < 0) {
            throw new IllegalArgumentException("Id não pode ser menor que 0!");
        }
        this.id = id;
    }

    protected LocalDateTime getCriadoEm() {
        return this.criadoEm;
    }

    /** Se a data for NULL, uma data atual será criada automáticamente. */
    /*protected void setCriadoEm(LocalDateTime criadoEm) {
        if (criadoEm == null) {
            this.criadoEm = LocalDateTime.now();
        } else {
            this.criadoEm = criadoEm;
        }
    }

    protected LocalDateTime getAtualizadoEm() {
        return this.atualizadoEm;
    }

    protected void setAtualizadoEm(LocalDateTime atualizadoEm) {
        this.atualizadoEm = atualizadoEm;
    }*/

}
