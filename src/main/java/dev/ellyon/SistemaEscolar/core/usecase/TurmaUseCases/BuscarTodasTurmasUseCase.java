package dev.ellyon.SistemaEscolar.core.usecase.TurmaUseCases;

import dev.ellyon.SistemaEscolar.core.entities.Turma;

import java.util.List;

public interface BuscarTodasTurmasUseCase {
    public List<Turma> execute();
}
