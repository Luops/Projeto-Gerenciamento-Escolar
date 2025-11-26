package dev.ellyon.SistemaEscolar.infra.mapper;

import dev.ellyon.SistemaEscolar.core.entities.Materia;
import dev.ellyon.SistemaEscolar.core.entities.Turma;
import dev.ellyon.SistemaEscolar.infra.dtos.MateriaDto;
import dev.ellyon.SistemaEscolar.infra.dtos.TurmaDto;
import org.springframework.stereotype.Component;

@Component
public class TurmaDtoMapper {
    // Resposta ao criar
    public TurmaDto toDto(Turma turma){
        TurmaDto dto = new TurmaDto();
        dto.setIdTurma(turma.getId());
        dto.setQteAlunos(turma.getQteAlunos());
        dto.setNumero(turma.getNumero());
        dto.setAno(turma.getAno());
        dto.setCriadoEm(turma.getCriadoEm());
        dto.setAtualizadoEm(turma.getAtualizadoEm());
        return dto;
    }

    public Turma toDomain(TurmaDto dto){
        return new Turma(
                dto.getIdTurma(),
                dto.getAtualizadoEm(),
                dto.getCriadoEm(),
                dto.getNumero(),
                dto.getQteAlunos(),
                dto.getAno()
        );
    }
}
