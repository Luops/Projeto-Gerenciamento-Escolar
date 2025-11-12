package dev.ellyon.SistemaEscolar.infra.exceptions;

/**
 * Exceção lançada quando um coordenador ESPECÍFICO não é encontrado.
 */

public class CoordenadorNaoEncontradoPeloIdException extends RuntimeException{
    public CoordenadorNaoEncontradoPeloIdException(Long id) {
        super("Coordenador não encontrado com ID: " + id);
    }
}
