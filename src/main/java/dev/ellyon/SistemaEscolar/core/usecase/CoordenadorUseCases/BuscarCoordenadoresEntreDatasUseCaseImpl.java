package dev.ellyon.SistemaEscolar.core.usecase.CoordenadorUseCases;

import dev.ellyon.SistemaEscolar.core.entities.Coordenador;
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
        if (dataInicio == null || dataFim == null) {
            throw new IllegalArgumentException("As datas não podem ser nulas ou vazias.");
        }
        if(dataInicio.isAfter(dataFim)) {
            throw new IllegalArgumentException("A data de início não pode ser posterior à data de fim.");
        }
    }
}
