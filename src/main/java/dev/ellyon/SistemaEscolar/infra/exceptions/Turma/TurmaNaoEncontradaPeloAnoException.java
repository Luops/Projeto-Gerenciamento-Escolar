package dev.ellyon.SistemaEscolar.infra.exceptions.Turma;

/**
 * Exceção lançada quando um coordenador ESPECÍFICO não é encontrado.
 */

public class TurmaNaoEncontradaPeloAnoException extends RuntimeException{
    public TurmaNaoEncontradaPeloAnoException(String ano) {
        super("Turma com o ano " + ano + " não foi encontrada.");
    }
}
