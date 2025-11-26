package dev.ellyon.SistemaEscolar.infra.persistence;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "turma")
public class TurmaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turma")
    private Long idTurma;

    @Column(name = "numero")
    private int numero;

    @Column(name = "qte_alunos")
    private int qteAlunos;

    @Column(name = "ano")
    private String ano;

    @Column(name = "criado_em")
    private LocalDateTime criadoEm;

    @Column(name = "atualizado_em")
    private LocalDateTime atualizadoEm;

    public TurmaEntity(Long idTurma, int numero, int qteAlunos, String ano, LocalDateTime criadoEm, LocalDateTime atualizadoEm) {
        this.idTurma = idTurma;
        this.numero = numero;
        this.qteAlunos = qteAlunos;
        this.ano = ano;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
    }

    public TurmaEntity() {
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
