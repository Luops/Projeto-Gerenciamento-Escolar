package dev.ellyon.SistemaEscolar.core.gateway;

import dev.ellyon.SistemaEscolar.core.entities.Turma;

import java.util.List;

public interface TurmaGateway {
    // CRUD
    Turma criarTurma(Turma turma);
    Turma buscarTurmaPeloId(Long idTurma);
    Turma editarTurma(Long idTurma, Turma turmaAtualizado);
    void deletarTurma(Long idTurma);

    // Queries
    long contarTotalTurmas();
    List<Turma> buscarTodasTurmas();
    Turma buscarTurmaPeloNumero(int numero);

    // Exeptions - Infra
    boolean isTurmaExistentePorId(Long id);
}
