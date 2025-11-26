package dev.ellyon.SistemaEscolar.core.usecase.TurmaUseCases;

import dev.ellyon.SistemaEscolar.core.entities.Turma;

public interface CriarTurmaUseCase {
    // Criar contrato de criar turma
    public Turma execute(Turma turma);
}
