package dev.ellyon.SistemaEscolar.core.usecase;

import dev.ellyon.SistemaEscolar.core.entities.Coordenador;
import dev.ellyon.SistemaEscolar.core.gateway.CoordenadorGateway;

public class CriarCoordenadorUseCaseImpl implements CriarCoordenadorUseCase{
    private final CoordenadorGateway coordenadorGateway; // Gateway para operações de coordenador
    public CriarCoordenadorUseCaseImpl(CoordenadorGateway coordenadorGateway) {
        this.coordenadorGateway = coordenadorGateway;
    }

    @Override
    public Coordenador execute(Coordenador coordenador, String email, String senha, Long entidadeId) {
        return coordenadorGateway.criarCoordenador(coordenador, email, senha, entidadeId);
    }
}
