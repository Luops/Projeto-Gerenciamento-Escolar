package dev.ellyon.SistemaEscolar.core.usecase.CoordenadorUseCases;

import dev.ellyon.SistemaEscolar.core.entities.Coordenador;
import dev.ellyon.SistemaEscolar.core.gateway.CoordenadorGateway;

public class DeletarCoordenadorUseCaseImpl implements DeletarCoordenadorUseCase {
    private final CoordenadorGateway coordenadorGateway;

    public DeletarCoordenadorUseCaseImpl(CoordenadorGateway coordenadorGateway) {
        this.coordenadorGateway = coordenadorGateway;
    }

    @Override
    public Coordenador execute(Long id) {
        return coordenadorGateway.deletarCoordenador(id);
    }
}
