package dev.ellyon.SistemaEscolar.infra.exceptions;

public class DuplicateCoordenadorEmailException extends RuntimeException{
    public DuplicateCoordenadorEmailException(String message) {
        super(message);
    }
}
