package dev.ellyon.SistemaEscolar.core.usecase.CoordenadorUseCases;

import dev.ellyon.SistemaEscolar.core.entities.Coordenador;
import dev.ellyon.SistemaEscolar.core.gateway.CoordenadorGateway;
import dev.ellyon.SistemaEscolar.infra.exceptions.DuplicateCoordenadorEmailException;
import dev.ellyon.SistemaEscolar.infra.exceptions.DuplicateCoordenadorIdException;

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
        // Validar campos preenchidos
        if(coordenador.getNome() == null || coordenador.getNome().isEmpty()) {
            throw new IllegalArgumentException("O nome do coordenador é obrigatório.");
        }
        if (coordenador.getSobrenome() == null || coordenador.getSobrenome().isEmpty()){
            throw new IllegalArgumentException("O sobrenome do coordenador é obrigatório.");
        }
        if (email == null || email.isEmpty()){
            throw new IllegalArgumentException("O email é obrigatório.");
        }
        if (senha == null || senha.isEmpty()){
            throw new IllegalArgumentException("A senha é obrigatório.");
        }
        if (entidadeId == null || entidadeId <= 0){
            throw new IllegalArgumentException("Problema ao informar a entidade.");
        }

        // Validar dados no banco
        if(coordenadorGateway.isCoordenadorExistentePorId(coordenador.getId())) {
            throw new DuplicateCoordenadorIdException("Já existe um coordenador com o ID gerado. Favor tentar novamente ou contacte o suporte.");
        }
        if(coordenadorGateway.isCoordenadorExistentePorEmail(email)) {
            throw new DuplicateCoordenadorEmailException("Já existe um coordenador com o email fornecido." + email);
        }
        return coordenadorGateway.criarCoordenador(coordenador, email, senha, entidadeId);
    }

}
