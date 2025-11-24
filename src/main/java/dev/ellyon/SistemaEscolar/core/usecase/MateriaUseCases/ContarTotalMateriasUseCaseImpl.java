package dev.ellyon.SistemaEscolar.core.usecase.MateriaUseCases;

import dev.ellyon.SistemaEscolar.core.gateway.CoordenadorGateway;
import dev.ellyon.SistemaEscolar.core.gateway.MateriaGateway;

public class ContarTotalMateriasUseCaseImpl implements ContarTotalMateriasUseCase {
    private final MateriaGateway materiaGateway;

    public ContarTotalMateriasUseCaseImpl(MateriaGateway materiaGateway) {
        this.materiaGateway = materiaGateway;
    }

    @Override
    public Long execute() {
        return materiaGateway.contarTotalMaterias();
    }
}
