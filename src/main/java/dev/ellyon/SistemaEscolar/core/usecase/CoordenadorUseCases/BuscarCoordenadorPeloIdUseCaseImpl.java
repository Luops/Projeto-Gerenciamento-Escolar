package dev.ellyon.SistemaEscolar.core.usecase.CoordenadorUseCases;

import dev.ellyon.SistemaEscolar.core.entities.Coordenador;
import dev.ellyon.SistemaEscolar.core.exceptions.ValidacaoException;
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
        validarId(id);
        return coordenadorGateway.buscarCoordenadorPeloId(id);
    }

    private void validarId(Long id) {
        if (id == null) {
            throw new ValidacaoException("O ID não pode ser nulo.");
        }

        if (id <= 0) {
            throw new ValidacaoException("O ID deve ser um número positivo.");
        }
    }
}
