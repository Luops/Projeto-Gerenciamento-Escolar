package dev.ellyon.SistemaEscolar.core.usecase;

import dev.ellyon.SistemaEscolar.core.entities.Coordenador;
import dev.ellyon.SistemaEscolar.core.gateway.CoordenadorGateway;

import java.util.List;

public class BuscarCoordenadorUseCaseImpl implements BuscarCoordenadorUseCase{
    private final CoordenadorGateway coordenadorGateway;

    public BuscarCoordenadorUseCaseImpl(CoordenadorGateway coordenadorGateway) {
        this.coordenadorGateway = coordenadorGateway;
    }

    @Override
    public List<Coordenador> execute() {
        return coordenadorGateway.buscarCoordenadores();
    }
}
