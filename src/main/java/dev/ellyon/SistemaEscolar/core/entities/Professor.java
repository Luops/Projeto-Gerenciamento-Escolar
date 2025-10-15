package dev.ellyon.SistemaEscolar.core.entities;

import java.util.List;

public final class Professor extends Entity {
    private String nome;
    private String sobrenome;
    private List<String> materias;
    private int totalAlunos;
    private List<Turma> turmas;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return this.sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public List<String> getMaterias() {
        return this.materias;
    }

    public void setMaterias(List<String> materias) {
        this.materias = materias;
    }

    public int getTotalAlunos() {
        return this.totalAlunos;
    }

    public void setTotalAlunos(int totalAlunos) {
        this.totalAlunos = totalAlunos;
    }

    public List<Turma> getTurmas() {
        return this.turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

}
