package dev.ellyon.SistemaEscolar.core.entities;

public final class Nota extends Entity{
    private Aluno aluno;
    private String materia;
    private Double pontuacao;
    private boolean aprovado;
    
    public Aluno getAluno() {
        return this.aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public String getMateria() {
        return this.materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public Double getPontuacao() {
        return this.pontuacao;
    }

    public void setPontuacao(Double pontuacao) {
        this.pontuacao = pontuacao;
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
