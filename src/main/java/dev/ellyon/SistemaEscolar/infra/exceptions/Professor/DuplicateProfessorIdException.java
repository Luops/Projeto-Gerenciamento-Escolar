package dev.ellyon.SistemaEscolar.infra.exceptions.Professor;

public class DuplicateProfessorIdException extends RuntimeException{
    public DuplicateProfessorIdException(String message) {
        super(message);
    }
}
