package dev.ellyon.SistemaEscolar.infra.exceptions.Coordenador;

/**
 * Exceção lançada quando um coordenador ESPECÍFICO não é encontrado.
 */

public class CoordenadorNaoEncontradoPeloIdException extends RuntimeException{
    public CoordenadorNaoEncontradoPeloIdException(Long id) {
        super("Coordenador com o ID " + id + " não foi encontrado.");
    }
}
