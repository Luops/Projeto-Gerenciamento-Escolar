package dev.ellyon.SistemaEscolar.core.usecase;

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
        return coordenadorGateway.buscarCoordenadoresEntreDatas(dataInicio, dataFim);
    }
}
