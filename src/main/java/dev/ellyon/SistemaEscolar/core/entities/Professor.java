package dev.ellyon.SistemaEscolar.core.entities;

import dev.ellyon.SistemaEscolar.core.enums.MateriaEnum;

import java.time.LocalDateTime;
import java.util.List;

public class Professor extends Entidade {
    private String nome;
    private String sobrenome;
    private int totalAlunos;

    // Campos opcionais (transientes) que podem ser preenchidos via join
    private String email;
    private Long entidadeId;

    public Professor(Long idProfessor, LocalDateTime atualizadoEm, LocalDateTime criadoEm, String nome, String sobrenome, int totalAlunos) {
        super(idProfessor, atualizadoEm, criadoEm);
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.totalAlunos = totalAlunos;
    }

    public Professor(String nome, String sobrenome, int totalAlunos) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.totalAlunos = totalAlunos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getTotalAlunos() {
        return totalAlunos;
    }

    public void setTotalAlunos(int totalAlunos) {
        this.totalAlunos = totalAlunos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getEntidadeId() {
        return entidadeId;
    }

    public void setEntidadeId(Long entidadeId) {
        this.entidadeId = entidadeId;
    }
}
