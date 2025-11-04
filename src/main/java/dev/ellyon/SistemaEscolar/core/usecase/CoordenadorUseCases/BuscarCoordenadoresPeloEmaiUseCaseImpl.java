package dev.ellyon.SistemaEscolar.core.usecase.CoordenadorUseCases;

import dev.ellyon.SistemaEscolar.core.entities.Coordenador;
import dev.ellyon.SistemaEscolar.core.gateway.CoordenadorGateway;

import java.util.List;

public class BuscarCoordenadoresPeloEmaiUseCaseImpl implements BuscarCoordenadoresPeloEmailUseCase{
    private final CoordenadorGateway coordenadorGateway;

    public BuscarCoordenadoresPeloEmaiUseCaseImpl(CoordenadorGateway coordenadorGateway) {
        this.coordenadorGateway = coordenadorGateway;
    }

    @Override
    public List<Coordenador> execute(String email) {
        return coordenadorGateway.buscarCoordenadoresPeloEmail(email);
    }
}
