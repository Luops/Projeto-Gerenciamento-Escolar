package dev.ellyon.SistemaEscolar.core.entities;

import java.time.LocalDateTime;

public class Turma extends Entidade {
    private int numero;
    private int qteAlunos;
    private String ano;

    public Turma(Long idTurma, LocalDateTime atualizadoEm, LocalDateTime criadoEm, int numero, int qteAlunos, String ano) {
        super(idTurma, atualizadoEm, criadoEm);
        this.numero = numero;
        this.qteAlunos = qteAlunos;
        this.ano = ano;
    }

    public Turma(int numero, int qteAlunos, String ano) {
        this.numero = numero;
        this.qteAlunos = qteAlunos;
        this.ano = ano;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
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
