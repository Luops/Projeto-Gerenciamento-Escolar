package dev.ellyon.SistemaEscolar.infra.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;

public class MateriaDto implements Serializable {
    private Long idMateria;
    private String nome;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;

    public MateriaDto(Long idMateria, String nome, LocalDateTime criadoEm, LocalDateTime atualizadoEm) {
        this.idMateria = idMateria;
        this.nome = nome;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
    }

    public MateriaDto() {
    }

    public Long getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Long idMateria) {
        this.idMateria = idMateria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }

    public LocalDateTime getAtualizadoEm() {
        return atualizadoEm;
    }

    public void setAtualizadoEm(LocalDateTime atualizadoEm) {
        this.atualizadoEm = atualizadoEm;
    }
}
