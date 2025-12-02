package dev.ellyon.SistemaEscolar.core.usecase.TurmaUseCases;

import dev.ellyon.SistemaEscolar.core.gateway.TurmaGateway;

public class ContarTotalTurmasUseCaseImpl implements ContarTotalTurmasUseCase {
    private final TurmaGateway turmaGateway;

    public ContarTotalTurmasUseCaseImpl(TurmaGateway turmaGateway) {
        this.turmaGateway = turmaGateway;
    }

    @Override
    public Long execute() {
        return turmaGateway.contarTotalTurmas();
    }
}
