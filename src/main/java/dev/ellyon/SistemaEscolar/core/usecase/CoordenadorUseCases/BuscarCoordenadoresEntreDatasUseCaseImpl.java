package dev.ellyon.SistemaEscolar.core.usecase.CoordenadorUseCases;

import dev.ellyon.SistemaEscolar.core.entities.Coordenador;
import dev.ellyon.SistemaEscolar.core.exceptions.ValidacaoException;
import dev.ellyon.SistemaEscolar.core.gateway.CoordenadorGateway;

import java.time.LocalDateTime;
import java.util.List;

public class BuscarCoordenadoresEntreDatasUseCaseImpl implements BuscarCoordenadoresEntreDatasUseCase {
    private final CoordenadorGateway coordenadorGateway;

    public BuscarCoordenadoresEntreDatasUseCaseImpl(CoordenadorGateway coordenadorGateway) {
        this.coordenadorGateway = coordenadorGateway;
    }

    @Override
    public List<Coordenador> execute(LocalDateTime dataInicio, LocalDateTime dataFim) {
        validarDatas(dataInicio, dataFim);
        return coordenadorGateway.buscarCoordenadoresEntreDatas(dataInicio, dataFim);
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

        if(dataFim.isAfter(LocalDateTime.now())) {
            throw new ValidacaoException("A data de fim não pode ser uma data futura.");
        }
    }
}
