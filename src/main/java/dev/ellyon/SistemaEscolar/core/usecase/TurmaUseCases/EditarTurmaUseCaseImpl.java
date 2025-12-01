package dev.ellyon.SistemaEscolar.core.usecase.TurmaUseCases;

import dev.ellyon.SistemaEscolar.core.entities.Materia;
import dev.ellyon.SistemaEscolar.core.entities.Turma;
import dev.ellyon.SistemaEscolar.core.exceptions.ValidacaoException;
import dev.ellyon.SistemaEscolar.core.gateway.MateriaGateway;
import dev.ellyon.SistemaEscolar.core.gateway.TurmaGateway;

public class EditarTurmaUseCaseImpl implements EditarTurmaUseCase {
    private final TurmaGateway turmaGateway;

    public EditarTurmaUseCaseImpl(TurmaGateway turmaGateway) {
        this.turmaGateway = turmaGateway;
    }

    @Override
    public Turma execute(Long idTurma, Turma turmaAtualizada) {
        validar(idTurma, turmaAtualizada);
        return turmaGateway.editarTurma(idTurma, turmaAtualizada);
    }

    private void validar(Long idTurma, Turma turmaAtualizada){
        // Validacoes
        if(idTurma == null || idTurma <= 0) {
            throw new ValidacaoException("ID inválido.");
        }
        if (turmaAtualizada.getNumero() < 0) {
            throw new ValidacaoException("Número da turma inválido. O número deve ser igual ou maior que 0.");
        }
        if (turmaAtualizada.getQteAlunos() < 0) {
            throw new ValidacaoException("Quantidade de alunos inválido. O número deve ser igual ou maior que 0.");
        }
        if (turmaAtualizada.getAno().isEmpty()) {
            throw new ValidacaoException("O ano da turma não pode ser vazio.");
        }
    }
}
