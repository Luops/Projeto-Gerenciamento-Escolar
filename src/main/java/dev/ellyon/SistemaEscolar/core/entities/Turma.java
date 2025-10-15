package dev.ellyon.SistemaEscolar.core.entities;

public final class Turma extends Entidade {
    private String numero;
    private int qteAlunos;
    private String ano;

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getQteAlunos() {
        return this.qteAlunos;
    }

    public void setQteAlunos(int qteAlunos) {
        this.qteAlunos = qteAlunos;
    }

    public String getAno() {
        return this.ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

}
