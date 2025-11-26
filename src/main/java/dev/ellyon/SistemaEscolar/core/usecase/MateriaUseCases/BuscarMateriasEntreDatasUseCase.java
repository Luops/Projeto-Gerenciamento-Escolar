package dev.ellyon.SistemaEscolar.core.usecase.MateriaUseCases;

import dev.ellyon.SistemaEscolar.core.entities.Materia;

import java.time.LocalDateTime;
import java.util.List;

public interface BuscarMateriasEntreDatasUseCase {
    public List<Materia> execute(LocalDateTime dataInicio, LocalDateTime dataFim);
}
