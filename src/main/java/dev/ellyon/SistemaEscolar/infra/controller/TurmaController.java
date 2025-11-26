package dev.ellyon.SistemaEscolar.infra.controller;

import dev.ellyon.SistemaEscolar.core.entities.Materia;
import dev.ellyon.SistemaEscolar.core.entities.Turma;
import dev.ellyon.SistemaEscolar.core.usecase.MateriaUseCases.*;
import dev.ellyon.SistemaEscolar.core.usecase.TurmaUseCases.CriarTurmaUseCase;
import dev.ellyon.SistemaEscolar.infra.dtos.MateriaDto;
import dev.ellyon.SistemaEscolar.infra.dtos.TurmaDto;
import dev.ellyon.SistemaEscolar.infra.mapper.MateriaDtoMapper;
import dev.ellyon.SistemaEscolar.infra.mapper.TurmaDtoMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/turma/")
public class TurmaController {
    private final TurmaDtoMapper turmaDtoMapper;
    private final CriarTurmaUseCase criarTurmaUseCase;

    // Constructor Injection
    public TurmaController(TurmaDtoMapper turmaDtoMapper, CriarTurmaUseCase criarTurmaUseCase) {
        this.turmaDtoMapper = turmaDtoMapper;
        this.criarTurmaUseCase = criarTurmaUseCase;
    }

    // Endpoint para criar uma nova turma
    @PostMapping("criar")
    public ResponseEntity<Map<String, Object>> criarTurma(@RequestBody TurmaDto turmaDto) {
        Turma turmaDominio = turmaDtoMapper.toDomain(turmaDto);

        // Executa o caso de uso para criar um nova turma. Pega o DTO, converte para domínio e passa para o caso de uso pois ele recebe somente a entidade de domínio
        Turma novaTurma = criarTurmaUseCase.execute(turmaDominio);

        // Prepara a resposta
        TurmaDto resposta = new TurmaDto();
        resposta.setIdTurma(novaTurma.getId());
        resposta.setNumero(novaTurma.getNumero());
        resposta.setQteAlunos(novaTurma.getQteAlunos());
        resposta.setAno(novaTurma.getAno());
        resposta.setCriadoEm(novaTurma.getCriadoEm());
        resposta.setAtualizadoEm(novaTurma.getAtualizadoEm());
        Map<String, Object> response = new HashMap<>();
        response.put("message: ", "Turma criada com sucesso!");
        response.put("dados da Turma: ", resposta);
        return ResponseEntity.ok(response);
    }
}
