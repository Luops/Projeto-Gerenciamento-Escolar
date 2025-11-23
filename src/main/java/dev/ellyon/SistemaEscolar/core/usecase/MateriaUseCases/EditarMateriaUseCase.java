package dev.ellyon.SistemaEscolar.core.usecase.MateriaUseCases;

import dev.ellyon.SistemaEscolar.core.entities.Materia;

public interface EditarMateriaUseCase {
    public Materia execute(Long idMateria, Materia materiaAtualizada);
}
