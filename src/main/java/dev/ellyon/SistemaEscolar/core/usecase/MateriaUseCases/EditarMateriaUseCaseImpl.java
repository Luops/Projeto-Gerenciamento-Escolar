package dev.ellyon.SistemaEscolar.core.usecase.MateriaUseCases;

import dev.ellyon.SistemaEscolar.core.entities.Coordenador;
import dev.ellyon.SistemaEscolar.core.entities.Materia;
import dev.ellyon.SistemaEscolar.core.exceptions.ValidacaoException;
import dev.ellyon.SistemaEscolar.core.gateway.MateriaGateway;

public class EditarMateriaUseCaseImpl implements EditarMateriaUseCase{
    private final MateriaGateway materiaGateway;

    public EditarMateriaUseCaseImpl(MateriaGateway materiaGateway) {
        this.materiaGateway = materiaGateway;
    }

    @Override
    public Materia execute(Long idMateria, Materia materiaAtualizada) {
        validar(idMateria, materiaAtualizada);
        return materiaGateway.editarMateria(idMateria, materiaAtualizada);
    }

    private void validar(Long idMateria, Materia materiaAtualizada){
        // Validacoes
        if(idMateria == null || idMateria <= 0) {
            throw new ValidacaoException("ID inválido.");
        }
        if (materiaAtualizada.getNome() == null || materiaAtualizada.getNome().isEmpty()) {
            throw new ValidacaoException("O nome da matéria não pode ser vazio.");
        }
        if (materiaAtualizada.getNome().length() < 5){
            throw new ValidacaoException("O nome da matéria deve ter pelo menos 5 caracteres.");
        }
    }
}
