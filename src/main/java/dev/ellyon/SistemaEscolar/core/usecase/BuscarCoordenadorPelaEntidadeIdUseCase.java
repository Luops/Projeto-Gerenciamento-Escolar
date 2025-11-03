package dev.ellyon.SistemaEscolar.core.usecase;

import dev.ellyon.SistemaEscolar.core.entities.Coordenador;

import java.time.LocalDateTime;
import java.util.List;

public interface BuscarCoordenadorPelaEntidadeIdUseCase {
    public List<Coordenador> execute(Long entidadeId);
}
