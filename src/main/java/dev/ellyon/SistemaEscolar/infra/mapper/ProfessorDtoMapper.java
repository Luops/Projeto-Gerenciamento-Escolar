package dev.ellyon.SistemaEscolar.infra.mapper;

import dev.ellyon.SistemaEscolar.core.entities.Coordenador;
import dev.ellyon.SistemaEscolar.core.entities.Professor;
import dev.ellyon.SistemaEscolar.infra.dtos.CoordenadorDto;
import dev.ellyon.SistemaEscolar.infra.dtos.ProfessorDto;
import dev.ellyon.SistemaEscolar.infra.persistence.MateriaEntity;
import dev.ellyon.SistemaEscolar.infra.persistence.UsuarioEntity;
import org.springframework.stereotype.Component;

@Component
public class ProfessorDtoMapper {
    // Resposta completa, incluindo dados do usuário (sem senha)
    public ProfessorDto toDto(Professor professor){
        ProfessorDto dto = new ProfessorDto();
        dto.setIdProfessor(professor.getId());
        dto.setNome(professor.getNome());
        dto.setSobrenome(professor.getSobrenome());
        dto.setAtualizadoEm(professor.getAtualizadoEm());
        dto.setCriadoEm(professor.getCriadoEm());
        // Pegar dados do coordenador (que já tem email e entidadeId)
        dto.setEmail(professor.getEmail());
        dto.setEntidadeId(professor.getEntidadeId());
        return dto;
    }

    public Coordenador toDomain(CoordenadorDto dto){
        return new Coordenador(
                dto.getId(),
                dto.getNome(),
                dto.getAtualizadoEm(),
                dto.getCriadoEm(),
                dto.getSobrenome()
        );
    }
}
