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
        response.put("error", ex.getMessage());
        response.put("message:", "Já existe um coordenador com o email fornecido. Por favor insira outro email.");
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(DuplicateCoordenadorIdException.class)
    public ResponseEntity<Map<String, String>> handleDuplicateIdException(DuplicateCoordenadorIdException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", ex.getMessage());
        response.put("message:", "Já existe um coordenador com o ID gerado. Favor tentar novamente ou contacte o suporte.");
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(CoordenadorNaoEncontradoPeloIdException.class)
    public ResponseEntity<Map<String, String>> handleCoordenadorNaoEncontradoPeloIdException(CoordenadorNaoEncontradoPeloIdException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", ex.getMessage());
        response.put("message:", "O coordenador com o ID fornecido não foi encontrado no sistema.");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
