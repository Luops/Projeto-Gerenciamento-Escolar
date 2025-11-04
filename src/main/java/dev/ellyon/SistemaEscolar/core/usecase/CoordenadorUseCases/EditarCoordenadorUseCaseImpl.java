package dev.ellyon.SistemaEscolar.core.usecase.CoordenadorUseCases;

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
public class EditarCoordenadorUseCaseImpl implements EditarCoordenadorUseCase {
    private final CoordenadorGateway coordenadorGateway;

    public EditarCoordenadorUseCaseImpl(CoordenadorGateway coordenadorGateway) {
        this.coordenadorGateway = coordenadorGateway;
    }

    @Override
    public Coordenador execute(Coordenador coordenadorAtualizado, String email, String senha) {
        // Validacoes
        if (coordenadorAtualizado.getNome() == null || coordenadorAtualizado.getNome().isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        if (coordenadorAtualizado.getSobrenome() == null || coordenadorAtualizado.getSobrenome().isBlank()) {
            throw new IllegalArgumentException("Sobrenome não pode ser vazio");
        }
        return coordenadorGateway.editarCoordenador(coordenadorAtualizado, email, senha);
    }
}
