package dev.ellyon.SistemaEscolar.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerExceptionsHandler extends RuntimeException{
    @ExceptionHandler(DuplicateCoordenadorEmailException.class)
    public ResponseEntity<Map<String, String>> handleDuplicateEmailException(DuplicateCoordenadorEmailException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("Error", ex.getMessage());
        response.put("Message:", "Já existe um coordenador com o email fornecido. Por favor insira outro email.");
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }
}
