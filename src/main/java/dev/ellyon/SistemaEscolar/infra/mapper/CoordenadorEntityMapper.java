package dev.ellyon.SistemaEscolar.infra.mapper;

import dev.ellyon.SistemaEscolar.core.entities.Coordenador;
import dev.ellyon.SistemaEscolar.infra.persistence.CoordenadorEntity;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/*
@Component
public class CoordenadorEntityMapper {
    public CoordenadorEntity toEntity(Coordenador coordenador){
        return new CoordenadorEntity(
                coordenador.getId(),
                coordenador.getNome(),
                coordenador.getCriadoEm(),
                coordenador.getAtualizadoEm(),
                coordenador.getSobrenome()
        );
    }

    public Coordenador toDomain(CoordenadorEntity coordenadorEntity){
        return new Coordenador(
                coordenadorEntity.getIdCoordenador(),
                coordenadorEntity.getNome(),
                coordenadorEntity.getCriadoEm(),
                coordenadorEntity.getAtualizadoEm(),
                coordenadorEntity.getSobrenome()
        );
    }
}*/
@Component
public class CoordenadorEntityMapper {

    public CoordenadorEntity toEntity(Coordenador coordenador) {
        CoordenadorEntity entity = new CoordenadorEntity();
        entity.setIdCoordenador(coordenador.getId());
        entity.setNome(coordenador.getNome());
        entity.setSobrenome(coordenador.getSobrenome());
        entity.setAtualizadoEm(coordenador.getAtualizadoEm());
        entity.setCriadoEm(coordenador.getCriadoEm());
        return entity;
    }

    public Coordenador toDomain(CoordenadorEntity entity) {
        // ✅ Aqui você precisa usar o construtor de Coordenador do domínio
        return new Coordenador(
                entity.getIdCoordenador(),
                entity.getNome(),
                entity.getAtualizadoEm(),
                entity.getCriadoEm(),
                entity.getSobrenome()
        );
    }

    // ✅ NOVA VERSÃO - converte com dados do Usuario
    public Coordenador toDomainWithUsuario(CoordenadorEntity entity) {
        Coordenador coordenador = new Coordenador(
                entity.getIdCoordenador(),
                entity.getNome(),
                entity.getAtualizadoEm(),
                entity.getCriadoEm(),
                entity.getSobrenome()
        );

        // Adicionar dados do usuario se existir
        if (entity.getUsuario() != null) {
            coordenador.setEmail(entity.getUsuario().getEmail());
            coordenador.setEntidadeId(entity.getUsuario().getEntidadeId());
        }

        return coordenador;
    }
}
