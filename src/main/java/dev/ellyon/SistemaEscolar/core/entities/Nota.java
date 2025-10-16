package dev.ellyon.SistemaEscolar.core.entities;

import dev.ellyon.SistemaEscolar.core.entities.enums.MateriaEnum;

public final class Nota extends Entidade {
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
        if (pontuacao < 0) {
            throw new IllegalArgumentException("Pontuação não pode ser menor que zero!");
        }
        this.pontuacao = pontuacao;
    }

    public Double getMedia() {
        return this.media;
    }

    public void setMedia(Double media) {
        if (media < 0 || media > 10) {
            throw new IllegalArgumentException("Média não pode ser menor que zero e maior que 10!");
        }

        this.media = media;
    }

    /**
     * Comparar se a pontuação é maior ou igual a variável média definida na classe.
     */
    public boolean isAprovado() {
        if (this.media != null) {
            if (this.pontuacao > media) {
                this.aprovado = true;
            } else {
                this.aprovado = false;
            }
        }

        return this.aprovado;
    }

    /*
     * Ajustes: atributo materia, getMateria e setMateria estavam como String e não
     * como MateriaEnum - 15/10/2025 Fabrício
     * Foi retirado o getAprovado que estava duplicado, e setAprovado por não fazer
     * sentido - 15/10/2025 Fabrício
     * Foi inserido o atributo media - 15/10/2025 Fabrício
     */

}
