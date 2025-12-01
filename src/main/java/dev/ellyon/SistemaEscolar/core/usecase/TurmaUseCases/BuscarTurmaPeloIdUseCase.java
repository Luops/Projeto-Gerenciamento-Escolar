package dev.ellyon.SistemaEscolar.core.usecase.TurmaUseCases;

import dev.ellyon.SistemaEscolar.core.entities.Turma;

public interface BuscarTurmaPeloIdUseCase {
    public Turma execute(Long id);
}
