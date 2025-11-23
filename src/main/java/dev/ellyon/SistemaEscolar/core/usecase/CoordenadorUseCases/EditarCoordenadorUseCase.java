package dev.ellyon.SistemaEscolar.core.usecase.CoordenadorUseCases;

import dev.ellyon.SistemaEscolar.core.entities.Coordenador;

public interface EditarCoordenadorUseCase {
    public Coordenador execute(Long id, Coordenador coordenadorAtualizado, String email, String senha);
}
