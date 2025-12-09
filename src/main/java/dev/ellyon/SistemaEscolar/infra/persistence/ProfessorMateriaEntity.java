package dev.ellyon.SistemaEscolar.infra.persistence;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "professor_materia")
public class ProfessorMateriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_professor_materia")
    private Long idProfessorMateria;

    @Column(name = "id_professor", nullable = false)
    private Long idProfessor;

    @Column(name = "id_materia", nullable = false)
    private Long idMateria;

    @Column(name = "criado_em", updatable = false)
    private LocalDateTime criadoEm;

    @Column(name = "atualizado_em")
    private LocalDateTime atualizadoEm;

    public ProfessorMateriaEntity(Long idProfessorMateria, Long idProfessor, Long idMateria, LocalDateTime criadoEm, LocalDateTime atualizadoEm) {
        this.idProfessorMateria = idProfessorMateria;
        this.idProfessor = idProfessor;
        this.idMateria = idMateria;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
    }

    public Long getIdProfessorMateria() {
        return idProfessorMateria;
    }

    public void setIdProfessorMateria(Long idProfessorMateria) {
        this.idProfessorMateria = idProfessorMateria;
    }

    public Long getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(Long idProfessor) {
        this.idProfessor = idProfessor;
    }

    public Long getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Long idMateria) {
        this.idMateria = idMateria;
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
