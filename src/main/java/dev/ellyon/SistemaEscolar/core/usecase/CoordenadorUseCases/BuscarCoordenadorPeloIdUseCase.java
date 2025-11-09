package dev.ellyon.SistemaEscolar.core.usecase.CoordenadorUseCases;

import dev.ellyon.SistemaEscolar.core.entities.Coordenador;

import java.util.List;
import java.util.Optional;

public interface BuscarCoordenadorPeloIdUseCase {
    public Coordenador execute(Long id);
}
