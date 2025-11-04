package dev.ellyon.SistemaEscolar.core.usecase.CoordenadorUseCases;

import dev.ellyon.SistemaEscolar.core.entities.Coordenador;
import dev.ellyon.SistemaEscolar.core.gateway.CoordenadorGateway;

import java.util.List;

public class BuscarTodosCoordenadoresUseCaseImpl implements BuscarTodosCoordenadoresUseCase {
    private final CoordenadorGateway coordenadorGateway;

    public BuscarTodosCoordenadoresUseCaseImpl(CoordenadorGateway coordenadorGateway) {
        this.coordenadorGateway = coordenadorGateway;
    }

    @Override
    public List<Coordenador> execute() {
        return coordenadorGateway.buscarTodosCoordenadores();
    }
}
