package dev.ellyon.SistemaEscolar.core.usecase.MateriaUseCases;

import dev.ellyon.SistemaEscolar.core.entities.Materia;
import dev.ellyon.SistemaEscolar.core.exceptions.ValidacaoException;
import dev.ellyon.SistemaEscolar.core.gateway.MateriaGateway;

public class CriarMateriaUseCaseImpl implements CriarMateriaUseCase{
    private final MateriaGateway materiaGateway;

    public CriarMateriaUseCaseImpl(MateriaGateway materiaGateway) {
        this.materiaGateway = materiaGateway;
    }

    @Override
    public Materia execute(Materia materia) {
        validarMateria(materia);
        return materiaGateway.criarMateria(materia);
    }

    private void validarMateria(Materia materia) {
        if (materia.getNome() == null || materia.getNome().isEmpty()) {
            throw new ValidacaoException("O nome da matéria não pode ser vazio.");
        }
        if (materia.getNome().length() < 5){
            throw new ValidacaoException("O nome da matéria deve ter pelo menos 5 caracteres.");
        }

    }
}
