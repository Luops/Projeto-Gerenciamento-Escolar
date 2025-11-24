package dev.ellyon.SistemaEscolar.core.usecase.MateriaUseCases;

import dev.ellyon.SistemaEscolar.core.entities.Coordenador;
import dev.ellyon.SistemaEscolar.core.entities.Materia;

import java.util.List;

public interface BuscarMateriasPeloNomeUseCase {
    public List<Materia> execute(String nome);
}
