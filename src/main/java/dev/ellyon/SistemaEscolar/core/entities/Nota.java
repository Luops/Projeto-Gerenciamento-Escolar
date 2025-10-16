package dev.ellyon.SistemaEscolar.core.entities;

import dev.ellyon.SistemaEscolar.core.entities.enums.MateriaEnum;

public final class Nota extends Entidade{
    private Aluno aluno;
    private MateriaEnum materia;
    private Double pontuacao;
    private Double media;
    private boolean aprovado;

    public Aluno getAluno() {
        return this.aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public MateriaEnum getMateria() {
        return materia;
    }

    public void setMateria(MateriaEnum materia) {
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
        // Comparar se a pontuação é maior ou igual a 7.0
    }

    /*
    * Ajustes: atributo materia, getMateria e setMateria estavam como String e não como MateriaEnum - 15/10/2025 Fabrício
    * Foi retirado o getAprovado que estava duplicado, e setAprovado por não fazer sentido - 15/10/2025 Fabrício
    * Foi inserido o atributo media - 15/10/2025 Fabrício*/

}
