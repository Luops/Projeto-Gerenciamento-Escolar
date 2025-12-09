package dev.ellyon.SistemaEscolar.core.usecase.ProfessorUseCases;

import dev.ellyon.SistemaEscolar.core.entities.Professor;

import java.util.List;

public interface CriarProfessorUseCase {
    public Professor execute(Professor professor, String email, String senha, Long entidadeId, List<Long> idTurma, List<Long> idMateria);
}
