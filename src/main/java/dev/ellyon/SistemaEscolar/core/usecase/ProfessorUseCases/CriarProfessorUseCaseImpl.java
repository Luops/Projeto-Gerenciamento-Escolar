package dev.ellyon.SistemaEscolar.core.usecase.ProfessorUseCases;

import dev.ellyon.SistemaEscolar.core.entities.Coordenador;
import dev.ellyon.SistemaEscolar.core.entities.Professor;
import dev.ellyon.SistemaEscolar.core.exceptions.ValidacaoException;
import dev.ellyon.SistemaEscolar.core.gateway.CoordenadorGateway;
import dev.ellyon.SistemaEscolar.core.gateway.ProfessorGateway;
import dev.ellyon.SistemaEscolar.infra.exceptions.Coordenador.DuplicateCoordenadorEmailException;
import dev.ellyon.SistemaEscolar.infra.exceptions.Coordenador.DuplicateCoordenadorIdException;

import java.util.List;

public class CriarProfessorUseCaseImpl implements CriarProfessorUseCase {
    private final ProfessorGateway professorGateway;

    public CriarProfessorUseCaseImpl(ProfessorGateway professorGateway) {
        this.professorGateway = professorGateway;
    }

    @Override
    public Professor execute(Professor professor, String email, String senha, Long entidadeId, List<Long> idTurma) {
        validar(professor, email, senha, entidadeId, idTurma);
        return professorGateway.criarProfessor(professor, email, senha, entidadeId, idTurma);
    }

    private void validar(Professor professor, String email, String senha, Long entidadeId, List<Long> idTurma){
        // Validar campos preenchidos
        if(professor.getNome() == null || professor.getNome().isEmpty()) {
            throw new ValidacaoException("O nome do professor é obrigatório.");
        }
        if (professor.getSobrenome() == null || professor.getSobrenome().isEmpty()){
            throw new ValidacaoException("O sobrenome do professor é obrigatório.");
        }
        if (email == null || email.isEmpty()){
            throw new ValidacaoException("O email é obrigatório.");
        }
        if( !email.contains("@") || !email.contains(".")){
            throw new ValidacaoException("O email fornecido é inválido.");
        }
        if (senha == null || senha.isEmpty()){
            throw new ValidacaoException("A senha é obrigatório.");
        }
        if (entidadeId == null || entidadeId <= 0){
            throw new ValidacaoException("Problema ao informar a entidade.");
        }
        if (idTurma == null || idTurma.isEmpty()){
            throw new ValidacaoException("Problema ao informar as turmas.");
        }

        // Validar dados no banco
        /*if(coordenadorGateway.isCoordenadorExistentePorId(coordenador.getId())) {
            throw new DuplicateCoordenadorIdException("Já existe um coordenador com o ID gerado. Favor tentar novamente ou contacte o suporte.");
        }
        if(coordenadorGateway.isCoordenadorExistentePorEmail(email)) {
            throw new DuplicateCoordenadorEmailException("Já existe um coordenador com o email fornecido." + email);
        }*/
    }

}
