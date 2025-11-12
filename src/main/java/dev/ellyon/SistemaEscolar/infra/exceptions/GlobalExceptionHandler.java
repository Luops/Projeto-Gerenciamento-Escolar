package dev.ellyon.SistemaEscolar.infra.exceptions;
import dev.ellyon.SistemaEscolar.core.exceptions.ValidacaoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Manipulador global de exceções da aplicação.
 * Captura exceções lançadas pelos Use Cases e Controllers e as converte em respostas HTTP apropriadas.
 *
 * Ordem de especificidade (do mais específico para o mais genérico):
 * 1. Exceções de domínio específicas (ValidacaoException, CoordenadorNaoEncontradoException, etc)
 * 2. Exceções do Spring (MissingServletRequestParameterException)
 * 3. RuntimeException (exceções genéricas do Java)
 * 4. Exception (última linha de defesa)
 */

@RestControllerAdvice
public class GlobalExceptionHandler {
    // ==================== EXCEÇÕES DE DOMÍNIO (Core) ====================

    /**
     * Trata exceções de validação de dados de entrada.
     * Exemplos: nome vazio, email inválido, senha curta, datas inválidas, etc.
     *
     * @param ex ValidacaoException lançada pelo Use Case
     * @return ResponseEntity com status 400 (Bad Request)
     */
    @ExceptionHandler(ValidacaoException.class)
    public ResponseEntity<Map<String, Object>> handleIllegalArgumentException(ValidacaoException ex) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status", HttpStatus.BAD_REQUEST.value());
        errorResponse.put("error", "Bad Request");
        errorResponse.put("message", ex.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    /**
     * Trata exceções quando um coordenador não é encontrado.
     * Exemplos: buscar por ID inexistente, buscar por email não cadastrado.
     *
     * @param ex CoordenadorNaoEncontradoException lançada pelo Gateway
     * @return ResponseEntity com status 404 (Not Found)
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, Object>> handleRuntimeException(RuntimeException ex) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status", HttpStatus.NOT_FOUND.value());
        errorResponse.put("error", "Not Found");
        errorResponse.put("message", ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    /**
     * Trata exceções quando há tentativa de cadastrar email duplicado.
     * Exemplo: criar coordenador com email que já existe no sistema.
     *
     * @param ex EmailJaCadastradoException lançada pelo Use Case
     * @return ResponseEntity com status 409 (Conflict)
     */
    /*
    @ExceptionHandler(EmailJaCadastradoException.class)
    public ResponseEntity<Map<String, Object>> handleEmailJaCadastrado(EmailJaCadastradoException ex) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status", HttpStatus.CONFLICT.value());
        errorResponse.put("error", "Conflito de Dados");
        errorResponse.put("message", ex.getMessage());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }*/

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGenericException(Exception ex) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponse.put("error", "Internal Server Error");
        errorResponse.put("message", "Erro interno: " + ex.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    // ==================== EXCEÇÕES DO SPRING FRAMEWORK ====================

    /**
     * Trata exceções quando um parâmetro obrigatório está ausente na requisição.
     * Exemplo: GET /buscarpelonome sem enviar o parâmetro "nome".
     *
     * @param ex MissingServletRequestParameterException lançada pelo Spring
     * @return ResponseEntity com status 400 (Bad Request)
     */
    /*
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<Map<String, Object>> handleMissingParams(MissingServletRequestParameterException ex) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status", HttpStatus.BAD_REQUEST.value());
        errorResponse.put("error", "Parâmetro Ausente");
        errorResponse.put("message", "Parâmetro obrigatório ausente: " + ex.getParameterName());
        errorResponse.put("parametro", ex.getParameterName());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }*/

    // ==================== EXCEÇÕES GENÉRICAS ====================

    /**
     * Trata RuntimeExceptions genéricas não capturadas pelos handlers acima.
     * ATENÇÃO: Este handler pode capturar exceções inesperadas.
     * Considere criar handlers específicos para exceções conhecidas.
     *
     * @param ex RuntimeException genérica
     * @return ResponseEntity com status 404 (Not Found) - considere usar 500 dependendo do caso
     *//*
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, Object>> handleRuntimeException(RuntimeException ex) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status", HttpStatus.NOT_FOUND.value());
        errorResponse.put("error", "Erro de Execução");
        errorResponse.put("message", ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }*/

    /**
     * Handler de última instância - captura TODAS as exceções não tratadas anteriormente.
     * Útil para evitar que erros inesperados exponham detalhes internos do sistema.
     *
     * ⚠️ IMPORTANTE: Em produção, considere logar a exceção completa para debugging,
     * mas retorne uma mensagem genérica ao usuário.
     *
     * @param ex Exception genérica
     * @return ResponseEntity com status 500 (Internal Server Error)
     *//*
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGenericException(Exception ex) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponse.put("error", "Erro Interno do Servidor");
        errorResponse.put("message", "Ocorreu um erro inesperado. Por favor, tente novamente mais tarde.");

        // TODO: Em produção, adicionar logging
        // logger.error("Erro não tratado: ", ex);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }*/
}
