package dev.ellyon.SistemaEscolar.core.usecase;

import dev.ellyon.SistemaEscolar.core.entities.Coordenador;

import java.util.List;

public interface BuscarTodosCoordenadoresUseCase {
    public List<Coordenador> execute();
}
