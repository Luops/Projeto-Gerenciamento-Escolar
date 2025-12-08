package dev.ellyon.SistemaEscolar.infra.exceptions.Professor;

public class DuplicateProfessorEmailException extends RuntimeException{
    public DuplicateProfessorEmailException(String message) {
        super(message);
    }
}
