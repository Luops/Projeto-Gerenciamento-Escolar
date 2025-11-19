package dev.ellyon.SistemaEscolar.infra.mapper;

import dev.ellyon.SistemaEscolar.core.entities.Materia;
import dev.ellyon.SistemaEscolar.infra.persistence.MateriaEntity;
import org.springframework.stereotype.Component;

@Component
public class MateriaEntityMapper {
    public MateriaEntity toEntity(Materia materia) {
        MateriaEntity entity = new MateriaEntity();
        entity.setIdMateria(materia.getIdMateria());
        entity.setNome(materia.getNome());
        entity.setCriadoEm(materia.getCriadoEm());
        entity.setAtualizadoEm(materia.getAtualizadoEm());
        return entity;
    }

    public Materia toDomain(MateriaEntity entity) {
        // Aqui você precisa usar o construtor de Coordenador do domínio
        return new Materia(
                entity.getIdMateria(),
                entity.getNome(),
                entity.getCriadoEm(),
                entity.getAtualizadoEm()
        );
    }
}
