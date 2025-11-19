package dev.ellyon.SistemaEscolar.infra.mapper;

import dev.ellyon.SistemaEscolar.core.entities.Coordenador;
import dev.ellyon.SistemaEscolar.infra.dtos.CoordenadorDto;
import dev.ellyon.SistemaEscolar.infra.persistence.CoordenadorEntity;
import dev.ellyon.SistemaEscolar.infra.persistence.UsuarioEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CoordenadorDtoMapper {
    // Resposta completa, incluindo dados do usuário (sem senha)
    public CoordenadorDto toDto(Coordenador coordenador, UsuarioEntity usuario){
        CoordenadorDto dto = new CoordenadorDto();
        dto.setId(coordenador.getId());
        dto.setNome(coordenador.getNome());
        dto.setSobrenome(coordenador.getSobrenome());
        dto.setAtualizadoEm(coordenador.getAtualizadoEm());
        dto.setCriadoEm(coordenador.getCriadoEm());
        // Pegar dados do coordenador (que já tem email e entidadeId)
        dto.setEmail(coordenador.getEmail());
        dto.setEntidadeId(coordenador.getEntidadeId());
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
