package dev.ellyon.SistemaEscolar.core.usecase.MateriaUseCases;

import dev.ellyon.SistemaEscolar.core.entities.Materia;
import dev.ellyon.SistemaEscolar.core.exceptions.ValidacaoException;
import dev.ellyon.SistemaEscolar.core.gateway.MateriaGateway;

public class BuscarMateriaPeloIdUseCaseImpl implements BuscarMateriaPeloIdUseCase {
    private final MateriaGateway materiaGateway;

    public BuscarMateriaPeloIdUseCaseImpl(MateriaGateway materiaGateway) {
        this.materiaGateway = materiaGateway;
    }

    @Override
    public Materia execute(Long id) {
        validarId(id);
        return materiaGateway.buscarMateriaPeloId(id);
    }

    private void validarId(Long id) {
        if (id == null) {
            throw new ValidacaoException("O ID não pode ser nulo.");
        }

        if (id <= 0) {
            throw new ValidacaoException("O ID deve ser um número positivo.");
        }
    }
}
