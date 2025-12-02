package dev.ellyon.SistemaEscolar.core.usecase.TurmaUseCases;

import dev.ellyon.SistemaEscolar.core.entities.Turma;
import dev.ellyon.SistemaEscolar.core.exceptions.ValidacaoException;
import dev.ellyon.SistemaEscolar.core.gateway.TurmaGateway;

public class DeletarTurmaUseCaseImpl implements DeletarTurmaUseCase {
    private final TurmaGateway turmaGateway;

    public DeletarTurmaUseCaseImpl(TurmaGateway turmaGateway) {
        this.turmaGateway = turmaGateway;
    }

    @Override
    public Turma execute(Long idTurma) {
        validar(idTurma);
        turmaGateway.deletarTurma(idTurma);
        return null;
    }

    private void validar(Long idTurma) {
        if (idTurma == null || idTurma <= 0) {
            throw new ValidacaoException("ID da turma inválido.");
        }
    }
}
