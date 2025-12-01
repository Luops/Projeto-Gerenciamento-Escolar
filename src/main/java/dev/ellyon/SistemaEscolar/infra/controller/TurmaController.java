package dev.ellyon.SistemaEscolar.infra.controller;

import dev.ellyon.SistemaEscolar.core.entities.Materia;
import dev.ellyon.SistemaEscolar.core.entities.Turma;
import dev.ellyon.SistemaEscolar.core.usecase.MateriaUseCases.*;
import dev.ellyon.SistemaEscolar.core.usecase.TurmaUseCases.BuscarTurmaPeloIdUseCase;
import dev.ellyon.SistemaEscolar.core.usecase.TurmaUseCases.CriarTurmaUseCase;
import dev.ellyon.SistemaEscolar.core.usecase.TurmaUseCases.EditarTurmaUseCase;
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
    private final BuscarTurmaPeloIdUseCase buscarTurmaPeloIdUseCase;
    private final EditarTurmaUseCase editarTurmaUseCase;

    // Constructor Injection
    public TurmaController(TurmaDtoMapper turmaDtoMapper, CriarTurmaUseCase criarTurmaUseCase, BuscarTurmaPeloIdUseCase buscarTurmaPeloIdUseCase, EditarTurmaUseCase editarTurmaUseCase) {
        this.turmaDtoMapper = turmaDtoMapper;
        this.criarTurmaUseCase = criarTurmaUseCase;
        this.buscarTurmaPeloIdUseCase = buscarTurmaPeloIdUseCase;
        this.editarTurmaUseCase = editarTurmaUseCase;
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

    // Endpoint para buscar uma turma pelo ID
    @GetMapping("buscarpeloid/{idTurma}" )
    public ResponseEntity<Map<String, Object>> buscarTurmaeloId(
            @PathVariable Long idTurma) {
        Turma turma = buscarTurmaPeloIdUseCase.execute(idTurma);

        TurmaDto resposta = turmaDtoMapper.toDto(turma);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "turma encontrada!");
        response.put("dados", resposta);

        return ResponseEntity.ok(response);
    }

    // Endpoint para editar uma turma
    @PutMapping("editar/{idTurma}")
    public ResponseEntity<Map<String, Object>> editarTurma(@PathVariable Long idTurma, @RequestBody TurmaDto turmaDto){
        try {
            // Converter DTO para dominio
            Turma turmaAtualizada = new Turma(idTurma, turmaDto.getAtualizadoEm(), turmaDto.getCriadoEm(), turmaDto.getNumero(), turmaDto.getQteAlunos(), turmaDto.getAno());

            // Executar o usecase
            Turma turmaEditada = editarTurmaUseCase.execute(idTurma, turmaAtualizada);

            // Preparar a resposta
            TurmaDto resposta = new TurmaDto();
            resposta.setIdTurma(turmaEditada.getId());
            resposta.setNumero(turmaEditada.getNumero());
            resposta.setQteAlunos(turmaEditada.getQteAlunos());
            resposta.setAno(turmaEditada.getAno());
            resposta.setCriadoEm(turmaEditada.getCriadoEm());
            resposta.setAtualizadoEm(turmaEditada.getAtualizadoEm());

            Map<String, Object> respostaCompleta = new HashMap<>();
            respostaCompleta.put("message", "Turma editada com sucesso!");
            respostaCompleta.put("dados da Turma", resposta);

            return ResponseEntity.ok(respostaCompleta);
        } catch (IllegalArgumentException error) {
            Map<String, Object> respostaErro = new HashMap<>();
            respostaErro.put("message", error.getMessage());
            return ResponseEntity.badRequest().body(respostaErro);
        } catch (RuntimeException error){
            Map<String, Object> respostaErro = new HashMap<>();
            respostaErro.put("message", error.getMessage());
            return ResponseEntity.status(500).body(respostaErro);
        }

    }

}
