package dev.ellyon.SistemaEscolar.core.usecase.CoordenadorUseCases;

import dev.ellyon.SistemaEscolar.core.entities.Coordenador;
import dev.ellyon.SistemaEscolar.core.exceptions.ValidacaoException;
import dev.ellyon.SistemaEscolar.core.gateway.CoordenadorGateway;

import java.util.List;

public class BuscarCoordenadoresPeloNomeUseCaseImpl implements BuscarCoordenadoresPeloNomeUseCase{
    private final CoordenadorGateway coordenadorGateway;

    public BuscarCoordenadoresPeloNomeUseCaseImpl(CoordenadorGateway coordenadorGateway) {
        this.coordenadorGateway = coordenadorGateway;
    }

    @Override
    public List<Coordenador> execute(String nome) {
        validarNome(nome);
        return coordenadorGateway.buscarCoordenadoresPeloNome(nome);
    }

    private void validarNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new ValidacaoException("O nome não pode ser nulo ou vazio.");
        }

        if (nome.trim().length() < 2) {
            throw new ValidacaoException("O nome deve ter no mínimo 2 caracteres.");
        }
    }
}
