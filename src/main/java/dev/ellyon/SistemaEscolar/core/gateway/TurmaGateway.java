package dev.ellyon.SistemaEscolar.core.gateway;

import dev.ellyon.SistemaEscolar.core.entities.Turma;

public interface TurmaGateway {
    // CRUD
    Turma criarTurma(Turma turma);
    Turma buscarTurmaPeloId(Long idTurma);
    Turma editarTurma(Long idTurma, Turma turmaAtualizado);

    // Exeptions - Infra
    boolean isTurmaExistentePorId(Long id);
}
