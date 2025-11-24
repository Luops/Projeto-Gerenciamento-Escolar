package dev.ellyon.SistemaEscolar.core.usecase.MateriaUseCases;

import dev.ellyon.SistemaEscolar.core.entities.Materia;
import dev.ellyon.SistemaEscolar.core.exceptions.ValidacaoException;
import dev.ellyon.SistemaEscolar.core.gateway.MateriaGateway;

public class DeletarMateriaUseCaseImpl implements DeletarMateriaUseCase{
    private final MateriaGateway materiaGateway;

    public DeletarMateriaUseCaseImpl(MateriaGateway materiaGateway) {
        this.materiaGateway = materiaGateway;
    }

    @Override
    public Materia execute(Long idMateria) {
        validarExistenciaMateria(idMateria);
        materiaGateway.deletarMateria(idMateria);
        return null;
    }

    private void validarExistenciaMateria(Long idMateria) {
        if (idMateria == null || idMateria <= 0) {
            throw new ValidacaoException("ID da matéria inválido.");
        }
    }
}
