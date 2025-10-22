package dev.ellyon.SistemaEscolar.infra.mapper;

import dev.ellyon.SistemaEscolar.core.entities.Coordenador;
import dev.ellyon.SistemaEscolar.infra.persistence.CoordenadorEntity;
import org.springframework.stereotype.Component;

@Component
public class CoordenadorEntityMapper {
    public CoordenadorEntity toEntity(Coordenador coordenador){
        return new CoordenadorEntity(
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

    public Coordenador toDomain(CoordenadorEntity coordenadorEntity){
        return new Coordenador(
                coordenadorEntity.getId(),
                coordenadorEntity.getNome(),
                coordenadorEntity.getEmail(),
                coordenadorEntity.getSenha(),
                coordenadorEntity.getEntidadeId(),
                coordenadorEntity.getRole(),
                coordenadorEntity.getCriadoEm(),
                coordenadorEntity.getAtualizadoEm(),
                coordenadorEntity.getSobrenome()
        );
    }
}
