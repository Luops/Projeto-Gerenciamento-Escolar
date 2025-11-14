package dev.ellyon.SistemaEscolar.core.usecase.CoordenadorUseCases;

import dev.ellyon.SistemaEscolar.core.gateway.CoordenadorGateway;

public class ContarTotalCoordenadoresUseCaseImpl implements ContarTotalCoordenadoresUseCase{
    private final CoordenadorGateway coordenadorGateway;

    public ContarTotalCoordenadoresUseCaseImpl(CoordenadorGateway coordenadorGateway) {
        this.coordenadorGateway = coordenadorGateway;
    }

    @Override
    public Long execute() {
        return coordenadorGateway.contarTotalCoodenadores();
    }
}
