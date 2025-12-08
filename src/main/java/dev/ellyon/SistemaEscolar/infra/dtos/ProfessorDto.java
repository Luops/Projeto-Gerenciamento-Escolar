package dev.ellyon.SistemaEscolar.infra.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;


public class ProfessorDto implements Serializable {
    private Long idProfessor;

    private String nome;

    private String sobrenome;

    private String email;

    private String senha;

    private Long entidadeId;

    private int totalAlunos;

    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;

    public ProfessorDto(Long idProfessor, String nome, String sobrenome, String email, String senha, Long entidadeId, int totalAlunos, LocalDateTime criadoEm, LocalDateTime atualizadoEm) {
        this.idProfessor = idProfessor;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
        this.entidadeId = entidadeId;
        this.totalAlunos = totalAlunos;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
    }

    public ProfessorDto() {
    }

    public Long getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(Long idProfessor) {
        this.idProfessor = idProfessor;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Long getEntidadeId() {
        return entidadeId;
    }

    public void setEntidadeId(Long entidadeId) {
        this.entidadeId = entidadeId;
    }

    public int getTotalAlunos() {
        return totalAlunos;
    }

    public void setTotalAlunos(int totalAlunos) {
        this.totalAlunos = totalAlunos;
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
