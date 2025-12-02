package dev.ellyon.SistemaEscolar.core.usecase.TurmaUseCases;

import dev.ellyon.SistemaEscolar.core.entities.Turma;

public interface DeletarTurmaUseCase {
    public Turma execute(Long idTurma);
}
