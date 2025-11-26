package dev.ellyon.SistemaEscolar.core.usecase.TurmaUseCases;

import dev.ellyon.SistemaEscolar.core.entities.Materia;
import dev.ellyon.SistemaEscolar.core.entities.Turma;
import dev.ellyon.SistemaEscolar.core.exceptions.ValidacaoException;
import dev.ellyon.SistemaEscolar.core.gateway.TurmaGateway;

public class CriarTurmaUseCaseImpl implements CriarTurmaUseCase{
    private final TurmaGateway turmaGateway;
    public CriarTurmaUseCaseImpl(TurmaGateway turmaGateway){
        this.turmaGateway = turmaGateway;
    }

    @Override
    public Turma execute(Turma turma) {
        validarTurma(turma);
        return turmaGateway.criarTurma(turma);
    }

    private void validarTurma(Turma turma) {
        if (turma.getNumero() < 1 ) {
            throw new ValidacaoException("O número da turma deve ser um número positivo e maior que 0.");
        }
        if (turma.getQteAlunos() < 1){
            throw new ValidacaoException("A quantidade de alunos deve ser pelo menos 1.");
        }
        if (turma.getAno().isEmpty()){
            throw new ValidacaoException("O ano da turma não pode ser vazio.");
        }
    }
}
