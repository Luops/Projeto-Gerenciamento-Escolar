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
    public Coordenador execute(Long id, Coordenador coordenadorAtualizado, String email, String senha) {
        validar(id, coordenadorAtualizado, email, senha);
        return coordenadorGateway.editarCoordenador(id, coordenadorAtualizado, email, senha);
    }

    private void validar(Long id, Coordenador coordenadorAtualizado, String email, String senha){
        // Validacoes
        if(id == null || id <= 0) {
            throw new IllegalArgumentException("ID inválido.");
        }
        if (coordenadorAtualizado.getNome() == null || coordenadorAtualizado.getNome().isBlank()) {
            throw new IllegalArgumentException("Nome é obrigatório.");
        }
        if (coordenadorAtualizado.getSobrenome() == null || coordenadorAtualizado.getSobrenome().isBlank()) {
            throw new IllegalArgumentException("Sobrenome é obrigatório.");
        }
        if (email == null || email.isEmpty()){
            throw new IllegalArgumentException("O email é obrigatório.");
        }
        if( !email.contains("@") || !email.contains(".")){
            throw new IllegalArgumentException("O email fornecido é inválido.");
        }
        if (senha == null || senha.isBlank()) {
            throw new IllegalArgumentException("A senha é obrigatória.");
        }
    }
}
