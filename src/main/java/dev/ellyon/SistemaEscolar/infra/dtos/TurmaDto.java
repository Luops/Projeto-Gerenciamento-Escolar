package dev.ellyon.SistemaEscolar.infra.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;

public class TurmaDto implements Serializable {
    private Long idTurma;
    private int numero;
    private int qteAlunos;
    private String ano;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;

    public TurmaDto(Long idTurma, int numero, int qteAlunos, String ano, LocalDateTime criadoEm, LocalDateTime atualizadoEm) {
        this.idTurma = idTurma;
        this.numero = numero;
        this.qteAlunos = qteAlunos;
        this.ano = ano;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
    }

    public TurmaDto() {
    }

    public Long getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Long idTurma) {
        this.idTurma = idTurma;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getQteAlunos() {
        return qteAlunos;
    }

    public void setQteAlunos(int qteAlunos) {
        this.qteAlunos = qteAlunos;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
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
