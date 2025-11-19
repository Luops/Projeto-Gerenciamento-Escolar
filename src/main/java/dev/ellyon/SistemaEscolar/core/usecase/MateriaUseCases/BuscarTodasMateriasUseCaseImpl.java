package dev.ellyon.SistemaEscolar.core.usecase.MateriaUseCases;

import dev.ellyon.SistemaEscolar.core.entities.Coordenador;
import dev.ellyon.SistemaEscolar.core.entities.Materia;
import dev.ellyon.SistemaEscolar.core.gateway.CoordenadorGateway;
import dev.ellyon.SistemaEscolar.core.gateway.MateriaGateway;
import dev.ellyon.SistemaEscolar.core.usecase.CoordenadorUseCases.BuscarTodosCoordenadoresUseCase;

import java.util.List;

public class BuscarTodasMateriasUseCaseImpl implements BuscarTodasMateriasUseCase {
    private final MateriaGateway materiaGateway;

    public BuscarTodasMateriasUseCaseImpl(MateriaGateway materiaGateway) {
        this.materiaGateway = materiaGateway;
    }

    @Override
    public List<Materia> execute() {
        return materiaGateway.buscarTodasMaterias();
    }
}
