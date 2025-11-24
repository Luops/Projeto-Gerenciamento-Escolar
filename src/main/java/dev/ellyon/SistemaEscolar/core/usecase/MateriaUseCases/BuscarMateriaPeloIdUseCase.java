package dev.ellyon.SistemaEscolar.core.usecase.MateriaUseCases;

import dev.ellyon.SistemaEscolar.core.entities.Materia;

public interface BuscarMateriaPeloIdUseCase {
    public Materia execute(Long id);
}
