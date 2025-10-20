package dev.ellyon.SistemaEscolar.core.entities;

import java.time.LocalDateTime;

/**
 * Classe principal que herdará todas as entidades do sistema.
 */
public abstract class Entidade {
    private Long id;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;

    public Entidade(Long id, LocalDateTime atualizadoEm, LocalDateTime criadoEm) {
        this.id = id;
        this.atualizadoEm = atualizadoEm;
        this.criadoEm = criadoEm;
    }

    public Entidade(){}

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        if (id < 0) {
            throw new IllegalArgumentException("Id não pode ser menor que 0!");
        }
        this.id = id;
    }

    public LocalDateTime getCriadoEm() {
        return this.criadoEm;
    }

    /** Se a data for NULL, uma data atual será criada automáticamente. */
    public void setCriadoEm(LocalDateTime criadoEm) {
        if (criadoEm == null) {
            this.criadoEm = LocalDateTime.now();
        } else {
            this.criadoEm = criadoEm;
        }
    }

    public LocalDateTime getAtualizadoEm() {
        return this.atualizadoEm;
    }

    public void setAtualizadoEm(LocalDateTime atualizadoEm) {
        this.atualizadoEm = atualizadoEm;
    }

}
