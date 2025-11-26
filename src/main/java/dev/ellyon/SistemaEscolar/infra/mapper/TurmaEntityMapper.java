package dev.ellyon.SistemaEscolar.infra.mapper;

import dev.ellyon.SistemaEscolar.core.entities.Materia;
import dev.ellyon.SistemaEscolar.core.entities.Turma;
import dev.ellyon.SistemaEscolar.infra.persistence.MateriaEntity;
import dev.ellyon.SistemaEscolar.infra.persistence.TurmaEntity;
import org.springframework.stereotype.Component;

@Component
public class TurmaEntityMapper {
    public TurmaEntity toEntity(Turma turma) {
        TurmaEntity entity = new TurmaEntity();
        entity.setIdTurma(turma.getId());
        entity.setNumero(turma.getNumero());
        entity.setQteAlunos(turma.getQteAlunos());
        entity.setAno(turma.getAno());
        entity.setCriadoEm(turma.getCriadoEm());
        entity.setAtualizadoEm(turma.getAtualizadoEm());
        return entity;
    }

    public Turma toDomain(TurmaEntity entity) {
        // Aqui você precisa usar o construtor de Turma do domínio
        return new Turma(
                entity.getIdTurma(),
                entity.getAtualizadoEm(),
                entity.getCriadoEm(),
                entity.getNumero(),
                entity.getQteAlunos(),
                entity.getAno()
        );
    }
}
