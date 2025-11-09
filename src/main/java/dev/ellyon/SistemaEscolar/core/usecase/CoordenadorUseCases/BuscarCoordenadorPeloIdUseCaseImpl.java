package dev.ellyon.SistemaEscolar.core.usecase.CoordenadorUseCases;

import dev.ellyon.SistemaEscolar.core.entities.Coordenador;
import dev.ellyon.SistemaEscolar.core.gateway.CoordenadorGateway;

import java.util.List;
import java.util.Optional;

public class BuscarCoordenadorPeloIdUseCaseImpl implements BuscarCoordenadorPeloIdUseCase{
    private final CoordenadorGateway coordenadorGateway;

    public BuscarCoordenadorPeloIdUseCaseImpl(CoordenadorGateway coordenadorGateway) {
        this.coordenadorGateway = coordenadorGateway;
    }

    @Override
    public Coordenador execute(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID inválido");
        }

        return coordenadorGateway.buscarCoordenadorPeloId(id);
    }
}
