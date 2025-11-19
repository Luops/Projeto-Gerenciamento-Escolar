package dev.ellyon.SistemaEscolar.infra.exceptions.Coordenador;

public class DuplicateCoordenadorIdException extends RuntimeException{
    public DuplicateCoordenadorIdException(String message) {
        super(message);
    }
}
