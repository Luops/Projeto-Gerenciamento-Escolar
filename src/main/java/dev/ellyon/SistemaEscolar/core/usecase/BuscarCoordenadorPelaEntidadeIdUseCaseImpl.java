package dev.ellyon.SistemaEscolar.core.usecase;

import dev.ellyon.SistemaEscolar.core.entities.Coordenador;
import dev.ellyon.SistemaEscolar.core.gateway.CoordenadorGateway;

import java.util.List;

public class BuscarCoordenadorPelaEntidadeIdUseCaseImpl implements BuscarCoordenadorPelaEntidadeIdUseCase{
    private final CoordenadorGateway coordenadorGateway;

    public BuscarCoordenadorPelaEntidadeIdUseCaseImpl(CoordenadorGateway coordenadorGateway) {
        this.coordenadorGateway = coordenadorGateway;
    }

    @Override
    public List<Coordenador> execute(Long entidadeId) {
        return coordenadorGateway.buscarCoordenadoresPelaEntidadeId(entidadeId);
    }
}
