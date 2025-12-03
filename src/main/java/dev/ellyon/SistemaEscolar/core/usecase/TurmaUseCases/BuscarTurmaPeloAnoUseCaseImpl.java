package dev.ellyon.SistemaEscolar.core.usecase.TurmaUseCases;

import dev.ellyon.SistemaEscolar.core.entities.Turma;
import dev.ellyon.SistemaEscolar.core.gateway.TurmaGateway;

import java.util.List;

public class BuscarTurmaPeloAnoUseCaseImpl implements BuscarTurmaPeloAnoUseCase {
    private final TurmaGateway turmaGateway;

    public BuscarTurmaPeloAnoUseCaseImpl(TurmaGateway turmaGateway) {
        this.turmaGateway = turmaGateway;
    }

    @Override
    public List<Turma> execute(String ano) {
        return turmaGateway.buscarTurmaPeloAno(ano);
    }

    void validar (String ano) {
        if (ano == null || ano.isEmpty()) {
            throw new IllegalArgumentException("Ano não pode ser nulo ou vazio");
        }
    }
}
