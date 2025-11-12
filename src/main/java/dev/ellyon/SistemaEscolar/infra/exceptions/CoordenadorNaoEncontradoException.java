package dev.ellyon.SistemaEscolar.infra.exceptions;

/**
 * Exceção lançada quando um coordenador ESPECÍFICO não é encontrado.
 */

public class CoordenadorNaoEncontradoException extends RuntimeException{
    public CoordenadorNaoEncontradoException(Long id) {
        super("Coordenador não encontrado com ID: " + id);
    }
}
