package dev.ellyon.SistemaEscolar.infra.exceptions;

public class DuplicateCoordenadorIdException extends RuntimeException{
    public DuplicateCoordenadorIdException(String message) {
        super(message);
    }
}
