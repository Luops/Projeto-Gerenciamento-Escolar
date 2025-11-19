package dev.ellyon.SistemaEscolar.core.usecase.MateriaUseCases;

import dev.ellyon.SistemaEscolar.core.entities.Materia;
import dev.ellyon.SistemaEscolar.core.gateway.MateriaGateway;

public class CriarMateriaUseCaseImpl implements CriarMateriaUseCase{
    private final MateriaGateway materiaGateway;

    public CriarMateriaUseCaseImpl(MateriaGateway materiaGateway) {
        this.materiaGateway = materiaGateway;
    }

    @Override
    public Materia execute(Materia materia) {

        return materiaGateway.criarMateria(materia);
    }
}
