package dev.ellyon.SistemaEscolar.infra.gateway;

import dev.ellyon.SistemaEscolar.core.entities.Materia;
import dev.ellyon.SistemaEscolar.core.entities.Turma;
import dev.ellyon.SistemaEscolar.core.gateway.MateriaGateway;
import dev.ellyon.SistemaEscolar.core.gateway.TurmaGateway;
import dev.ellyon.SistemaEscolar.infra.exceptions.Materia.MateriaNaoEncontradaPeloIdException;
import dev.ellyon.SistemaEscolar.infra.mapper.MateriaEntityMapper;
import dev.ellyon.SistemaEscolar.infra.mapper.TurmaEntityMapper;
import dev.ellyon.SistemaEscolar.infra.persistence.MateriaEntity;
import dev.ellyon.SistemaEscolar.infra.persistence.MateriaRepository;
import dev.ellyon.SistemaEscolar.infra.persistence.TurmaEntity;
import dev.ellyon.SistemaEscolar.infra.persistence.TurmaRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class TurmaRepositoryGateway implements TurmaGateway {
    private final TurmaRepository turmaRepository;
    private final TurmaEntityMapper turmaEntityMapper;

    public TurmaRepositoryGateway(TurmaRepository turmaRepository, TurmaEntityMapper turmaEntityMapper) {
        this.turmaRepository = turmaRepository;
        this.turmaEntityMapper = turmaEntityMapper;
    }

    @Override
    public Turma criarTurma(Turma turma) {
        TurmaEntity novaTurma = new TurmaEntity();
        novaTurma.setNumero(turma.getNumero());
        novaTurma.setQteAlunos(turma.getQteAlunos());
        novaTurma.setAno(turma.getAno());
        novaTurma.setCriadoEm(LocalDateTime.now());
        novaTurma.setAtualizadoEm(LocalDateTime.now());
        TurmaEntity turmaSalva = turmaRepository.save(novaTurma);
        return turmaEntityMapper.toDomain(turmaSalva);
    }
}
