package dev.ellyon.SistemaEscolar.core.usecase;

import dev.ellyon.SistemaEscolar.core.entities.Coordenador;

import java.time.LocalDateTime;
import java.util.List;

public interface BuscarCoordenadoresEntreDatasUseCase {
    public List<Coordenador> execute(LocalDateTime dataInicio, LocalDateTime dataFim);
}
