package dev.ellyon.SistemaEscolar.infra.gateway;

import dev.ellyon.SistemaEscolar.core.entities.Turma;
import dev.ellyon.SistemaEscolar.core.gateway.TurmaGateway;
import dev.ellyon.SistemaEscolar.infra.exceptions.Materia.MateriaNaoEncontradaPeloIdException;
import dev.ellyon.SistemaEscolar.infra.exceptions.Turma.TurmaNaoEncontradaPeloAnoException;
import dev.ellyon.SistemaEscolar.infra.exceptions.Turma.TurmaNaoEncontradaPeloIdException;
import dev.ellyon.SistemaEscolar.infra.exceptions.Turma.TurmaNaoEncontradaPeloNumeroException;
import dev.ellyon.SistemaEscolar.infra.mapper.TurmaEntityMapper;
import dev.ellyon.SistemaEscolar.infra.persistence.MateriaEntity;
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

    // Verifica se já existe uma turma com o id fornecido ao criar ou editar
    @Override
    public boolean isTurmaExistentePorId(Long idTurma) {
        return turmaRepository.findAll().stream().anyMatch(turma -> turma.getIdTurma().equals(idTurma));
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

    @Override
    public List<Turma> buscarTodasTurmas() {
        return turmaRepository.findAll().stream().map(turmaEntityMapper::toDomain).toList();
    }

    @Override
    public Turma buscarTurmaPeloId(Long idTurma) {
        TurmaEntity turmaEntity = turmaRepository.findById(idTurma)
                .orElseThrow(() -> new TurmaNaoEncontradaPeloIdException(idTurma));

        return turmaEntityMapper.toDomain(turmaEntity);
    }

    @Override
    public Turma editarTurma(Long idTurma, Turma turmaAtualizada) {
        // 1. Buscar a matéria existente
        TurmaEntity turmaExistente = turmaRepository.findById(idTurma)
                .orElseThrow(() -> new TurmaNaoEncontradaPeloIdException(idTurma));

        // 2. Atualizar os campos necessários
        if (turmaAtualizada.getNumero() != 0){
            turmaExistente.setNumero(turmaAtualizada.getNumero());
        }
        if (turmaAtualizada.getQteAlunos() != 0){
            turmaExistente.setQteAlunos(turmaAtualizada.getQteAlunos());
        }
        turmaExistente.setAno(turmaAtualizada.getAno());



        // 3. Atualizar a data de atualização
        turmaExistente.setAtualizadoEm(LocalDateTime.now());

        // 4. Salvar as alterações
        TurmaEntity turmaSalva = turmaRepository.save(turmaExistente);

        return turmaEntityMapper.toDomain(turmaSalva);
    }

    @Override
    public void deletarTurma(Long idTurma) {
        // 1. Buscar turma para garantir que existe
        TurmaEntity turma = turmaRepository.findById(idTurma)
                .orElseThrow(() -> new TurmaNaoEncontradaPeloIdException(idTurma));

        // 2. Deletar materia
        turmaRepository.deleteById(idTurma);
    }

    @Override
    public long contarTotalTurmas() {
        return turmaRepository.count();
    }

    @Override
    public Turma buscarTurmaPeloNumero(int numero) {
        TurmaEntity turmaEntity = turmaRepository.findByNumero(numero)
                .orElseThrow(() -> new TurmaNaoEncontradaPeloNumeroException(numero));

        return turmaEntityMapper.toDomain(turmaEntity);
    }

    @Override
    public List<Turma> buscarTurmaPeloAno(String ano) {
        List<TurmaEntity> turmasEntity = turmaRepository.findByAno(ano);
        if (turmasEntity.isEmpty()) {
            throw new TurmaNaoEncontradaPeloAnoException(null);
        }
        return turmasEntity.stream().map(turmaEntityMapper::toDomain).toList();
    }

    @Override
    public List<Turma> buscarTurmasEntreDatasCriacao(LocalDateTime dataInicio, LocalDateTime dataFim) {
        return turmaRepository.findByCriadoEmBetween(dataInicio, dataFim).stream().map(turmaEntityMapper::toDomain).toList();
    }
}
