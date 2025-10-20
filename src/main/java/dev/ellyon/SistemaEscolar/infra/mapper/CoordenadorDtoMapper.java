package dev.ellyon.SistemaEscolar.infra.mapper;

import dev.ellyon.SistemaEscolar.core.entities.Coordenador;
import dev.ellyon.SistemaEscolar.infra.dtos.CoordenadorDto;
import org.springframework.stereotype.Component;

@Component
public class CoordenadorDtoMapper {
    public CoordenadorDto toDto(Coordenador coordenador){
        return new CoordenadorDto(
            coordenador.getId(),
            coordenador.getNome(),
            coordenador.getEmail(),
            coordenador.getSenha(),
            coordenador.getEntidadeId(),
            coordenador.getRole(),
            coordenador.getCriadoEm(),
            coordenador.getAtualizadoEm(),
            coordenador.getSobrenome()
        );
    }

    public Coordenador toDomain(CoordenadorDto coordenadorDto){
        return new Coordenador(
            coordenadorDto.getId(),
            coordenadorDto.getNome(),
            coordenadorDto.getEmail(),
            coordenadorDto.getSenha(),
            coordenadorDto.getEntidadeId(),
            coordenadorDto.getRole(),
            coordenadorDto.getCriadoEm(),
            coordenadorDto.getAtualizadoEm(),
            coordenadorDto.getSobrenome()
        );
    }
}
