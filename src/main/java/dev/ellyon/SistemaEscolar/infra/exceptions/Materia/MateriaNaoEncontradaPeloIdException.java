package dev.ellyon.SistemaEscolar.infra.exceptions.Materia;

/**
 * Exceção lançada quando um coordenador ESPECÍFICO não é encontrado.
 */

public class MateriaNaoEncontradaPeloIdException extends RuntimeException{
    public MateriaNaoEncontradaPeloIdException(Long id) {
        super("Materia com o ID " + id + " não foi encontrada.");
    }
}
