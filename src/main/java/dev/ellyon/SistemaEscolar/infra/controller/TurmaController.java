package dev.ellyon.SistemaEscolar.infra.controller;

import dev.ellyon.SistemaEscolar.core.entities.Materia;
import dev.ellyon.SistemaEscolar.core.entities.Turma;
import dev.ellyon.SistemaEscolar.core.usecase.MateriaUseCases.*;
import dev.ellyon.SistemaEscolar.core.usecase.TurmaUseCases.*;
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
    private final DeletarTurmaUseCase deletarTurmaUseCase;
    private final ContarTotalTurmasUseCase contarTotalTurmasUseCase;
    private final BuscarTodasTurmasUseCase buscarTodasTurmasUseCase;
    private final BuscarTurmaPeloNumeroUseCase buscarTurmaPeloNumeroUseCase;
    private final BuscarTurmaPeloAnoUseCase buscarTurmaPeloAnoUseCase;
    private final BuscarTurmasEntreDatasUseCase buscarTurmasEntreDatasUseCase;

    // Constructor Injection
    public TurmaController(TurmaDtoMapper turmaDtoMapper, CriarTurmaUseCase criarTurmaUseCase, BuscarTurmaPeloIdUseCase buscarTurmaPeloIdUseCase, EditarTurmaUseCase editarTurmaUseCase, DeletarTurmaUseCase deletarTurmaUseCase, ContarTotalTurmasUseCase contarTotalTurmasUseCase, BuscarTodasTurmasUseCase buscarTodasTurmasUseCase, BuscarTurmaPeloNumeroUseCase buscarTurmaPeloNumeroUseCase, BuscarTurmaPeloAnoUseCase buscarTurmaPeloAnoUseCase, BuscarTurmasEntreDatasUseCase buscarTurmasEntreDatasUseCase) {
        this.turmaDtoMapper = turmaDtoMapper;
        this.criarTurmaUseCase = criarTurmaUseCase;
        this.buscarTurmaPeloIdUseCase = buscarTurmaPeloIdUseCase;
        this.editarTurmaUseCase = editarTurmaUseCase;
        this.deletarTurmaUseCase = deletarTurmaUseCase;
        this.contarTotalTurmasUseCase = contarTotalTurmasUseCase;
        this.buscarTodasTurmasUseCase = buscarTodasTurmasUseCase;
        this.buscarTurmaPeloNumeroUseCase = buscarTurmaPeloNumeroUseCase;
        this.buscarTurmaPeloAnoUseCase = buscarTurmaPeloAnoUseCase;
        this.buscarTurmasEntreDatasUseCase = buscarTurmasEntreDatasUseCase;
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

    // Endpoint para listar turmas
    @GetMapping("buscartodas")
    public ResponseEntity<Map<String, Object>>buscarTodasTurmas() {
        List<Turma> turmas = buscarTodasTurmasUseCase.execute();
        Map<String, Object> response = new HashMap<>();
        // Verificar se a lista está vazia
        if (turmas.isEmpty()) {
            response.put("message", "Nenhuma turma foi encontrada.");
            response.put("total", 0);
            response.put("dados", List.of()); // Lista vazia
            return ResponseEntity.ok(response);
        }

        List<TurmaDto> turmaDto = turmas.stream()
                .map(turma -> turmaDtoMapper.toDto(turma)) // Converte cada turma para DTO
                .toList();
        response.put("message", "Turmas encontradas com sucesso!");
        response.put("total", turmaDto.size());
        response.put("dados", turmaDto);

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

    // Endpoint para deletar turma
    @DeleteMapping("deletar/{idTurma}")
    public ResponseEntity<Map<String, Object>> deletarTurma(@PathVariable Long idTurma) {
        try {
            // Buscar turma antes de deletar para pegar os dados
            Turma turmaDeletada = buscarTurmaPeloIdUseCase.execute(idTurma);

            deletarTurmaUseCase.execute(idTurma);

            // Contar total após deleção
            long totalTurmas = contarTotalTurmasUseCase.execute();

            Map<String, Object> response = new HashMap<>();
            response.put("message", "Turma deletada com sucesso!");
            response.put("turmaDeletada", Map.of(
                    "id", idTurma,
                    "número", turmaDeletada.getNumero(),
                    "ano", turmaDeletada.getAno()
            ));
            response.put("total de Turmas: ", totalTurmas);

            return ResponseEntity.ok(response);

        } catch (IllegalArgumentException e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("Error", e.getMessage());
            return ResponseEntity.badRequest().body(errorResponse);

        } catch (RuntimeException e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("Error", e.getMessage());
            return ResponseEntity.status(404).body(errorResponse);
        }
    }

    // Endpoint para buscar turmas pelo número
    @GetMapping("buscarpelonumero/{numero}")
    public ResponseEntity<Map<String, Object>> buscarPeloNumero(@PathVariable int numero) {
        Turma turma = buscarTurmaPeloNumeroUseCase.execute(numero);

        TurmaDto resposta = turmaDtoMapper.toDto(turma);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "turma encontrada!");
        response.put("dados", resposta);

        return ResponseEntity.ok(response);
    }

    // Endpoint para buscar turmas pelo ano
    @GetMapping("buscarpeloano/{ano}")
    public ResponseEntity<Map<String, Object>> buscarPeloAno(@PathVariable String ano) {
        List<Turma> turmas = buscarTurmaPeloAnoUseCase.execute(ano);
        Map<String, Object> response = new HashMap<>();
        // Verificar se a lista está vazia
        if (turmas.isEmpty()) {
            response.put("message", "Nenhuma turma foi encontrada.");
            response.put("total", 0);
            response.put("dados", List.of()); // Lista vazia
            return ResponseEntity.ok(response);
        }

        List<TurmaDto> turmaDto = turmas.stream()
                .map(turma -> turmaDtoMapper.toDto(turma)) // Converte cada turma para DTO
                .toList();
        response.put("message", "Turmas encontradas com sucesso!");
        response.put("total", turmaDto.size());
        response.put("dados", turmaDto);

        return ResponseEntity.ok(response);
    }

    // Endpoint para listar turmas pela data de cadastro
    @GetMapping("buscarpeladata")
    public ResponseEntity<Map<String, Object>> buscarTurmasPeloPeriodo(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicio,
                                                                         @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFim) {
        List<Turma> turmas = buscarTurmasEntreDatasUseCase.execute(dataInicio, dataFim);
        Map<String, Object> response = new HashMap<>();
        // Verificar se a lista está vazia
        if (turmas.isEmpty()) {
            response.put("message", "Nenhuma turma foi encontrada no período informado.");
            response.put("dataInicio", dataInicio);
            response.put("dataFim", dataFim);
            response.put("total", 0);
            response.put("dados", List.of()); // Lista vazia
            return ResponseEntity.ok(response);
        }

        // Se encontrou turmas, converte para DTO
        List<TurmaDto> turmasDto = turmas.stream()
                .map(turma -> turmaDtoMapper.toDto(turma))
                .toList();

        response.put("message", "Turmas encontradas com sucesso!");
        response.put("dataInicio", dataInicio);
        response.put("dataFim", dataFim);
        response.put("total", turmasDto.size());
        response.put("dados", turmasDto);

        return ResponseEntity.ok(response);
    }


}
