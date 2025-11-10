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
        validarEmail(email);
        return coordenadorGateway.buscarCoordenadoresPeloEmail(email);
    }

    private void validarEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("O email não pode ser nulo ou vazio.");
        }

        if (!email.contains("@") || !email.contains(".")) {
            throw new IllegalArgumentException("O email fornecido é inválido.");
        }
    }
}
