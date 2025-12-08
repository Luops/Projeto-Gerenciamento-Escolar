package dev.ellyon.SistemaEscolar.infra.exceptions.Professor;

/**
 * Exceção lançada quando um coordenador ESPECÍFICO não é encontrado.
 */

public class ProfessorNaoEncontradoPeloIdException extends RuntimeException{
    public ProfessorNaoEncontradoPeloIdException(Long id) {
        super("Professor com o ID " + id + " não foi encontrado.");
    }
}
