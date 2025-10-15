package dev.ellyon.SistemaEscolar.core.entities;

import java.util.List;

public final class Boletim extends Entity{
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
    }

    public boolean getAprovado() {
        return this.aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }

}
