package dev.ellyon.SistemaEscolar.core.usecase.CoordenadorUseCases;

import dev.ellyon.SistemaEscolar.core.entities.Coordenador;

import java.util.List;

public interface BuscarTodosCoordenadoresUseCase {
    public List<Coordenador> execute();
}
