package dev.ellyon.SistemaEscolar.infra.exceptions.Coordenador;

public class DuplicateCoordenadorEmailException extends RuntimeException{
    public DuplicateCoordenadorEmailException(String message) {
        super(message);
    }
}
