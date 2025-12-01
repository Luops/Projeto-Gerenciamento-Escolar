package dev.ellyon.SistemaEscolar.core.usecase.TurmaUseCases;

import dev.ellyon.SistemaEscolar.core.entities.Turma;
import dev.ellyon.SistemaEscolar.core.exceptions.ValidacaoException;
import dev.ellyon.SistemaEscolar.core.gateway.TurmaGateway;

public class BuscarTurmaPeloIdUseCaseImpl implements BuscarTurmaPeloIdUseCase {
    private final TurmaGateway turmaGateway;
    public BuscarTurmaPeloIdUseCaseImpl(TurmaGateway turmaGateway) {
        this.turmaGateway = turmaGateway;
    }

    @Override
    public Turma execute(Long id) {
        validarId(id);
        return turmaGateway.buscarTurmaPeloId(id);
    }

    private void validarId(Long id) {
        if (id == null) {
            throw new ValidacaoException("O ID não pode ser nulo.");
        }

        if (id <= 0) {
            throw new ValidacaoException("O ID deve ser um número positivo.");
        }
    }
}
