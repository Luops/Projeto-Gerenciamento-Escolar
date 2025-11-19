package dev.ellyon.SistemaEscolar.infra.mapper;

import dev.ellyon.SistemaEscolar.core.entities.Materia;
import dev.ellyon.SistemaEscolar.infra.dtos.MateriaDto;
import org.springframework.stereotype.Component;

@Component
public class MateriaDtoMapper {
    // Resposta ao criar
    public MateriaDto toDto(Materia materia){
        MateriaDto dto = new MateriaDto();
        dto.setIdMateria(materia.getIdMateria());
        dto.setNome(materia.getNome());
        dto.setCriadoEm(materia.getCriadoEm());
        dto.setAtualizadoEm(materia.getAtualizadoEm());
        return dto;
    }

    public Materia toDomain(MateriaDto dto){
        return new Materia(
                dto.getIdMateria(),
                dto.getNome(),
                dto.getCriadoEm(),
                dto.getAtualizadoEm()
        );
    }
}
