package dev.ellyon.SistemaEscolar.core.usecase.TurmaUseCases;

import dev.ellyon.SistemaEscolar.core.entities.Turma;

import java.time.LocalDateTime;
import java.util.List;

public interface BuscarTurmasEntreDatasUseCase {
    public List<Turma> execute(LocalDateTime dataInicio, LocalDateTime dataFim);
}
