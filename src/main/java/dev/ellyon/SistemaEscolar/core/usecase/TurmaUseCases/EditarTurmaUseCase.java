package dev.ellyon.SistemaEscolar.core.usecase.TurmaUseCases;

import dev.ellyon.SistemaEscolar.core.entities.Turma;

public interface EditarTurmaUseCase {
    public Turma execute(Long idTurma, Turma turmaAtualizada);
}
