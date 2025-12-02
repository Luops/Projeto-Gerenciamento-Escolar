package dev.ellyon.SistemaEscolar.core.usecase.TurmaUseCases;

import dev.ellyon.SistemaEscolar.core.entities.Turma;

import java.util.List;

public interface BuscarTurmaPeloNumeroUseCase {
    public Turma execute(int numero);
}
