package dev.ellyon.SistemaEscolar.core.usecase;

import dev.ellyon.SistemaEscolar.core.entities.Coordenador;
import dev.ellyon.SistemaEscolar.core.gateway.CoordenadorGateway;
import dev.ellyon.SistemaEscolar.infra.exceptions.DuplicateCoordenadorEmailException;

/*
public class CriarCoordenadorUseCaseImpl implements CriarCoordenadorUseCase{
    private final CoordenadorGateway coordenadorGateway; // Gateway para operações de coordenador
    public CriarCoordenadorUseCaseImpl(CoordenadorGateway coordenadorGateway) {
        this.coordenadorGateway = coordenadorGateway;
    }

    @Override
    public Coordenador execute(Coordenador coordenador) {
        return coordenadorGateway.criarCoordenador(coordenador);
    }
}*/
public class CriarCoordenadorUseCaseImpl implements CriarCoordenadorUseCase {
    private final CoordenadorGateway coordenadorGateway;

    public CriarCoordenadorUseCaseImpl(CoordenadorGateway coordenadorGateway) {
        this.coordenadorGateway = coordenadorGateway;
    }

    @Override
    public Coordenador execute(Coordenador coordenador, String email, String senha, Long entidadeId) {
        if(coordenadorGateway.isCoordenadorExistentePorEmail(email)) {
            throw new DuplicateCoordenadorEmailException("Já existe um coordenador com o email fornecido." + email);
        }
        return coordenadorGateway.criarCoordenador(coordenador, email, senha, entidadeId);
    }

}
