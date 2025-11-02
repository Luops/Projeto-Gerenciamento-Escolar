package dev.ellyon.SistemaEscolar.core.usecase;

import dev.ellyon.SistemaEscolar.core.entities.Coordenador;
import dev.ellyon.SistemaEscolar.core.gateway.CoordenadorGateway;

import java.util.List;

public class BuscarCoordenadoresPeloNomeUseCaseImpl implements BuscarCoordenadoresPeloNomeUseCase{
    private final CoordenadorGateway coordenadorGateway;

    public BuscarCoordenadoresPeloNomeUseCaseImpl(CoordenadorGateway coordenadorGateway) {
        this.coordenadorGateway = coordenadorGateway;
    }

    @Override
    public List<Coordenador> execute(String nome) {
        return coordenadorGateway.buscarCoordenadoresPeloNome(nome);
    }
}
