package dev.ellyon.SistemaEscolar.infra.mapper;

import dev.ellyon.SistemaEscolar.core.entities.Coordenador;
import dev.ellyon.SistemaEscolar.infra.dtos.CoordenadorDto;
import dev.ellyon.SistemaEscolar.infra.persistence.UsuarioEntity;
import org.springframework.stereotype.Component;
/*
@Component
public class CoordenadorDtoMapper {
    public CoordenadorDto toDto(Coordenador coordenador){
        return new CoordenadorDto(
                coordenador.getId(),
                coordenador.getNome(),
                coordenador.getCriadoEm(),
                coordenador.getAtualizadoEm(),
                coordenador.getSobrenome()
        );
    }

    public Coordenador toDomain(CoordenadorDto coordenadorDto){
        return new Coordenador(
                coordenadorDto.getId(),
                coordenadorDto.getNome(),
                coordenadorDto.getCriadoEm(),
                coordenadorDto.getAtualizadoEm(),
                coordenadorDto.getSobrenome()
        );
    }
}*/

@Component
public class CoordenadorDtoMapper {
    public CoordenadorDto toDto(Coordenador coordenador, UsuarioEntity usuario){
        CoordenadorDto dto = new CoordenadorDto();
        dto.setId(coordenador.getId());
        dto.setNome(coordenador.getNome());
        dto.setSobrenome(coordenador.getSobrenome());
        dto.setCriadoEm(coordenador.getCriadoEm());
        dto.setAtualizadoEm(coordenador.getAtualizadoEm());
        // Adicionar dados do usuario (SEM senha)
        if (usuario != null) {
            dto.setEmail(usuario.getEmail());
            dto.setEntidadeId(usuario.getEntidadeId());
        }
        return dto;
    }

    public Coordenador toDomain(CoordenadorDto dto){
        return new Coordenador(
                dto.getId(),
                dto.getNome(),
                dto.getCriadoEm(),
                dto.getAtualizadoEm(),
                dto.getSobrenome()
        );
    }
}
