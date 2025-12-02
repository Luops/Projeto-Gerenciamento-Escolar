package dev.ellyon.SistemaEscolar.infra.exceptions.Turma;

/**
 * Exceção lançada quando um coordenador ESPECÍFICO não é encontrado.
 */

public class TurmaNaoEncontradaPeloNumeroException extends RuntimeException{
    public TurmaNaoEncontradaPeloNumeroException(int numero) {
        super("Turma com o número " + numero + " não foi encontrada.");
    }
}
