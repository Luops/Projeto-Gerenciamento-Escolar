package dev.ellyon.SistemaEscolar.core.entities;

import java.util.List;

public final class Boletim extends Entidade{
    private Aluno aluno;
    private List<Nota> notas;
    private boolean aprovado;

    public Aluno getAluno() {
        return this.aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public List<Nota> getNotas() {
        return this.notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    public boolean isAprovado() {
        return this.aprovado;
        // Comparar se todas as notas são aprovadas.
        // Se todas estão aprovadas, retorna true
    }

    /*
    * Ajustes: Foi retirado o getAprovado que estava duplicado, e setAprovado por não fazer sentido - 15/10/2025 Fabrício
    * */
}
