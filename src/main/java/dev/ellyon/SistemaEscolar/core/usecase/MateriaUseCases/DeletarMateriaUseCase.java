package dev.ellyon.SistemaEscolar.core.usecase.MateriaUseCases;

import dev.ellyon.SistemaEscolar.core.entities.Materia;

public interface DeletarMateriaUseCase {
    public Materia execute(Long idMateria);
}
