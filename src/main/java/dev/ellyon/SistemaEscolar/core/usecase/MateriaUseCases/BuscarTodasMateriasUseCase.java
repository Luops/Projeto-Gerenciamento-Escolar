package dev.ellyon.SistemaEscolar.core.usecase.MateriaUseCases;

import dev.ellyon.SistemaEscolar.core.entities.Materia;

import java.util.List;

public interface BuscarTodasMateriasUseCase {
    public List<Materia> execute();
}
