package dev.ellyon.SistemaEscolar.core.usecase.TurmaUseCases;

import dev.ellyon.SistemaEscolar.core.entities.Materia;
import dev.ellyon.SistemaEscolar.core.entities.Turma;
import dev.ellyon.SistemaEscolar.core.exceptions.ValidacaoException;
import dev.ellyon.SistemaEscolar.core.gateway.MateriaGateway;
import dev.ellyon.SistemaEscolar.core.gateway.TurmaGateway;

import java.time.LocalDateTime;
import java.util.List;

public class BuscarTurmasEntreDatasUseCaseImpl implements BuscarTurmasEntreDatasUseCase {
    private final TurmaGateway turmaGateway;

    public BuscarTurmasEntreDatasUseCaseImpl(TurmaGateway turmaGateway) {
        this.turmaGateway = turmaGateway;
    }

    @Override
    public List<Turma> execute(LocalDateTime dataInicio, LocalDateTime dataFim) {
        validarDatas(dataInicio, dataFim);
        return turmaGateway.buscarTurmasEntreDatasCriacao(dataInicio, dataFim);
    }

    private void validarDatas(LocalDateTime dataInicio, LocalDateTime dataFim) {
        if (dataInicio == null) {
            throw new ValidacaoException("A data de início não pode ser nula.");
        }

        if(dataInicio.isBefore(LocalDateTime.of(1900, 1, 1, 0, 0))) {
            throw new ValidacaoException("A data de início não pode ser anterior a 01/01/1900.");
        }

        if (dataFim == null) {
            throw new ValidacaoException("A data de fim não pode ser nula.");
        }

        if(dataInicio.isAfter(dataFim)) {
            throw new ValidacaoException("A data de início não pode ser posterior à data de fim.");
        }
    }
}
