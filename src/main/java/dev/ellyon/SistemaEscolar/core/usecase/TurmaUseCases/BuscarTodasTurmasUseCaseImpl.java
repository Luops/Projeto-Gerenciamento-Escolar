package dev.ellyon.SistemaEscolar.core.usecase.TurmaUseCases;

import dev.ellyon.SistemaEscolar.core.entities.Materia;
import dev.ellyon.SistemaEscolar.core.entities.Turma;
import dev.ellyon.SistemaEscolar.core.gateway.TurmaGateway;

import java.util.List;

public class BuscarTodasTurmasUseCaseImpl implements BuscarTodasTurmasUseCase {
    private final TurmaGateway turmaGateway;

    public BuscarTodasTurmasUseCaseImpl(TurmaGateway turmaGateway) {
        this.turmaGateway = turmaGateway;
    }

    @Override
    public List<Turma> execute() {
        return turmaGateway.buscarTodasTurmas();
    }
}
