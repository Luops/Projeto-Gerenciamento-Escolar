package dev.ellyon.SistemaEscolar.infra.gateway;

import dev.ellyon.SistemaEscolar.core.entities.Materia;
import dev.ellyon.SistemaEscolar.core.gateway.MateriaGateway;
import dev.ellyon.SistemaEscolar.infra.mapper.MateriaEntityMapper;
import dev.ellyon.SistemaEscolar.infra.persistence.MateriaEntity;
import dev.ellyon.SistemaEscolar.infra.persistence.MateriaRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MateriaRepositoryGateway implements MateriaGateway {
    private final MateriaRepository materiaRepository;
    private final MateriaEntityMapper materiaEntityMapper;

    public MateriaRepositoryGateway(MateriaRepository materiaRepository, MateriaEntityMapper materiaEntityMapper) {
        this.materiaRepository = materiaRepository;
        this.materiaEntityMapper = materiaEntityMapper;
    }

    @Override
    public Materia criarMateria(Materia materia) {
        MateriaEntity novaMateria = new MateriaEntity();
        novaMateria.setNome(materia.getNome());
        novaMateria.setCriadoEm(LocalDateTime.now());
        novaMateria.setAtualizadoEm(LocalDateTime.now());
        MateriaEntity materiaSalva = materiaRepository.save(novaMateria);
        return materiaEntityMapper.toDomain(materiaSalva);
    }
}
