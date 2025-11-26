package dev.ellyon.SistemaEscolar.core.usecase.MateriaUseCases;

import dev.ellyon.SistemaEscolar.core.entities.Materia;
import dev.ellyon.SistemaEscolar.core.exceptions.ValidacaoException;
import dev.ellyon.SistemaEscolar.core.gateway.MateriaGateway;

import java.time.LocalDateTime;
import java.util.List;

public class BuscarMateriasEntreDatasUseCaseImpl implements BuscarMateriasEntreDatasUseCase {
    private final MateriaGateway materiaGateway;

    public BuscarMateriasEntreDatasUseCaseImpl(MateriaGateway materiaGateway) {
        this.materiaGateway = materiaGateway;
    }

    @Override
    public List<Materia> execute(LocalDateTime dataInicio, LocalDateTime dataFim) {
        validarDatas(dataInicio, dataFim);
        return materiaGateway.buscarMateriasEntreDatasCriacao(dataInicio, dataFim);
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
