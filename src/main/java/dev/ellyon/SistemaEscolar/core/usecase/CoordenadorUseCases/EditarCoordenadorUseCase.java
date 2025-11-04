package dev.ellyon.SistemaEscolar.core.usecase.CoordenadorUseCases;

import dev.ellyon.SistemaEscolar.core.entities.Coordenador;

/*
public interface CriarCoordenadorUseCase {
    public Coordenador execute(Coordenador coordenador);
}*/
public interface EditarCoordenadorUseCase {
    public Coordenador execute(Coordenador coordenadorAtualizado, String email, String senha);
}
