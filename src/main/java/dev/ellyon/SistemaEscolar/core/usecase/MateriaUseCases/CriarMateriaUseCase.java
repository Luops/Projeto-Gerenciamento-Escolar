package dev.ellyon.SistemaEscolar.core.usecase.MateriaUseCases;

import dev.ellyon.SistemaEscolar.core.entities.Materia;

public interface CriarMateriaUseCase {
    // Criar "contrato" para criar materia
    public Materia execute(Materia materia);
}
