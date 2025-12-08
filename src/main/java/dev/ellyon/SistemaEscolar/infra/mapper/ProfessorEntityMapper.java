package dev.ellyon.SistemaEscolar.infra.mapper;

import dev.ellyon.SistemaEscolar.core.entities.Coordenador;
import dev.ellyon.SistemaEscolar.core.entities.Professor;
import dev.ellyon.SistemaEscolar.infra.persistence.CoordenadorEntity;
import dev.ellyon.SistemaEscolar.infra.persistence.ProfessorEntity;
import org.springframework.stereotype.Component;

@Component
public class ProfessorEntityMapper {

    public ProfessorEntity toEntity(Professor professor) {
        ProfessorEntity entity = new ProfessorEntity();
        entity.setIdProfessor(professor.getId());
        entity.setNome(professor.getNome());
        entity.setSobrenome(professor.getSobrenome());
        entity.setAtualizadoEm(professor.getAtualizadoEm());
        entity.setCriadoEm(professor.getCriadoEm());
        return entity;
    }

    public Professor toDomain(ProfessorEntity entity) {
        // Aqui você precisa usar o construtor de Professor do domínio
        return new Professor(
                entity.getIdProfessor(),
                entity.getAtualizadoEm(),
                entity.getCriadoEm(),
                entity.getNome(),
                entity.getSobrenome(),
                entity.getTotalAlunos()
        );
    }

    // NOVA VERSÃO - converte com dados do Usuario e Turma
    public Professor toDomainWithUsuarioTurma(ProfessorEntity entity) {
        Professor professor = new Professor(
                entity.getIdProfessor(),
                entity.getAtualizadoEm(),
                entity.getCriadoEm(),
                entity.getNome(),
                entity.getSobrenome(),
                entity.getTotalAlunos()
        );

        // Adicionar dados do usuario se existir
        if (entity.getUsuario() != null) {
            professor.setEmail(entity.getUsuario().getEmail());
            professor.setEntidadeId(entity.getUsuario().getEntidadeId());
        }

        return professor;
    }
}
