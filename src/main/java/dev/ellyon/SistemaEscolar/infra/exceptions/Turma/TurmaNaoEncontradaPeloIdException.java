package dev.ellyon.SistemaEscolar.infra.exceptions.Turma;

/**
 * Exceção lançada quando um coordenador ESPECÍFICO não é encontrado.
 */

public class TurmaNaoEncontradaPeloIdException extends RuntimeException{
    public TurmaNaoEncontradaPeloIdException(Long id) {
        super("Turma com o ID " + id + " não foi encontrada.");
    }
}
