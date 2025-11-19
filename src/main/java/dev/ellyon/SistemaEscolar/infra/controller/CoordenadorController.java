package dev.ellyon.SistemaEscolar.infra.controller;


import dev.ellyon.SistemaEscolar.core.entities.Coordenador;
import dev.ellyon.SistemaEscolar.core.usecase.CoordenadorUseCases.*;
import dev.ellyon.SistemaEscolar.infra.dtos.CoordenadorDto;
import dev.ellyon.SistemaEscolar.infra.mapper.CoordenadorDtoMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/coordenador/")
public class CoordenadorController {
    private final CriarCoordenadorUseCase criarCoordenadorUseCase; // Executar caso de uso de criar coordenador
    private final CoordenadorDtoMapper coordenadorDtoMapper; // Mapper para converter entre Coordenador e CoordenadorDto
    private final BuscarTodosCoordenadoresUseCase buscarCoordenadorUseCase;
    private final BuscarCoordenadoresPeloNomeUseCase buscarCoordenadoresPeloNomeUseCase;
    private final BuscarCoordenadoresEntreDatasUseCase buscarCoordenadoresEntreDatasUseCaseUseCase;
    private final BuscarCoordenadorPelaEntidadeIdUseCase buscarCoordenadorPelaEntidadeIdUseCase;
    private final BuscarCoordenadoresPeloEmailUseCase buscarCoordenadoresPeloEmailUseCase;
    private final BuscarCoordenadorPeloIdUseCase buscarCoordenadorPeloId;
    private final EditarCoordenadorUseCase editarCoordenadorUseCase;
    private final DeletarCoordenadorUseCase deletarCoordenadorUseCase;
    private final ContarTotalCoordenadoresUseCase contarTotalCoordenadoresUseCase;

    // Constructor Injection
    public CoordenadorController(CriarCoordenadorUseCase criarCoordenadorUseCase, CoordenadorDtoMapper coordenadorDtoMapper, BuscarTodosCoordenadoresUseCase buscarCoordenadorUseCase, BuscarCoordenadoresPeloNomeUseCase buscarCoordenadoresPeloNomeUseCase, BuscarCoordenadoresEntreDatasUseCase buscarCoordenadoresEntreDatasUseCaseUseCase, BuscarCoordenadorPelaEntidadeIdUseCase buscarCoordenadorPelaEntidadeIdUseCase, BuscarCoordenadoresPeloEmailUseCase buscarCoordenadoresPeloEmailUseCase, BuscarCoordenadorPeloIdUseCase buscarCoordenadorPeloId, EditarCoordenadorUseCase editarCoordenadorUseCase, DeletarCoordenadorUseCase deletarCoordenadorUseCase, ContarTotalCoordenadoresUseCase contarTotalCoordenadoresUseCase) {
        this.criarCoordenadorUseCase = criarCoordenadorUseCase;
        this.coordenadorDtoMapper = coordenadorDtoMapper;
        this.buscarCoordenadorUseCase = buscarCoordenadorUseCase;
        this.buscarCoordenadoresPeloNomeUseCase = buscarCoordenadoresPeloNomeUseCase;
        this.buscarCoordenadoresEntreDatasUseCaseUseCase = buscarCoordenadoresEntreDatasUseCaseUseCase;
        this.buscarCoordenadorPelaEntidadeIdUseCase = buscarCoordenadorPelaEntidadeIdUseCase;
        this.buscarCoordenadoresPeloEmailUseCase = buscarCoordenadoresPeloEmailUseCase;
        this.buscarCoordenadorPeloId = buscarCoordenadorPeloId;
        this.editarCoordenadorUseCase = editarCoordenadorUseCase;
        this.deletarCoordenadorUseCase = deletarCoordenadorUseCase;
        this.contarTotalCoordenadoresUseCase = contarTotalCoordenadoresUseCase;
    }

    // Endpoint para listar coordenadores
    @GetMapping("buscartodos")
    public ResponseEntity<Map<String, Object>>buscarTodosCoordenadores() {
        List<Coordenador> coordenadores = buscarCoordenadorUseCase.execute();
        Map<String, Object> response = new HashMap<>();
        // Verificar se a lista está vazia
        if (coordenadores.isEmpty()) {
            response.put("message", "Nenhum coordenador foi encontrado.");
            response.put("total", 0);
            response.put("dados", List.of()); // Lista vazia
            return ResponseEntity.ok(response);
        }

        List<CoordenadorDto> coordenadoresDto = coordenadores.stream()
                .map(coordenador -> coordenadorDtoMapper.toDto(coordenador, null)) // Converte cada coordenador para DTO sem incluir senha
                .toList();
        response.put("message", "Coordenadores encontrados com sucesso!");
        response.put("total", coordenadoresDto.size());
        response.put("dados", coordenadoresDto);

        return ResponseEntity.ok(response);
    }

    @PostMapping("criar")
    public ResponseEntity<Map<String, Object>> criarCoordenador(@RequestBody CoordenadorDto coordenadorDto) {
        Coordenador coordenadorDominio = coordenadorDtoMapper.toDomain(coordenadorDto);

        // Executa o caso de uso para criar um novo coordenador. Pega o DTO, converte para domínio e passa para o caso de uso pois ele recebe somente a entidade de domínio
        Coordenador novoCoordenador = criarCoordenadorUseCase.execute(
                coordenadorDominio,
                coordenadorDto.getEmail(),
                coordenadorDto.getSenha(),
                coordenadorDto.getEntidadeId()
        );

        // Criar resposta MANUALMENTE para incluir email e entidadeId (SEM senha)
        CoordenadorDto resposta = new CoordenadorDto();
        resposta.setId(novoCoordenador.getId());
        resposta.setNome(novoCoordenador.getNome());
        resposta.setSobrenome(novoCoordenador.getSobrenome());
        resposta.setEmail(coordenadorDto.getEmail());
        resposta.setEntidadeId(coordenadorDto.getEntidadeId());
        resposta.setCriadoEm(novoCoordenador.getCriadoEm());
        resposta.setAtualizadoEm(novoCoordenador.getAtualizadoEm());

        Map<String, Object> response = new HashMap<>();
        response.put("message: ", "Coordenador criado com sucesso!");
        response.put("dados do Coordenador: ", resposta);
        return ResponseEntity.ok(response);
    }

    // Endpoint para listar coordenadores pelo nome
    @GetMapping("buscarpelonome")
    public ResponseEntity<Map<String, Object>> buscarCoordenadoresPeloNome(@RequestParam String nome) {
        List<Coordenador> coordenadores = buscarCoordenadoresPeloNomeUseCase.execute(nome);
        Map<String, Object> response = new HashMap<>();
        // Verificar se a lista está vazia
        if (coordenadores.isEmpty()) {
            response.put("message", "Nenhum coordenador foi encontrado com este nome.");
            response.put("nome", nome);
            response.put("total", 0);
            response.put("dados", List.of()); // Lista vazia
            return ResponseEntity.ok(response);
        }
        List<CoordenadorDto> coordenadoresDto = coordenadores.stream()
                .map(coordenador -> coordenadorDtoMapper.toDto(coordenador, null)) // Converte cada coordenador para DTO sem incluir senha
                .toList();
        response.put("message", "Coordenadores encontrados com sucesso!");
        response.put("nome", nome);
        response.put("total", coordenadoresDto.size());
        response.put("dados", coordenadoresDto);

        return ResponseEntity.ok(response);
    }

    // Endpoint para listar coordenadores pela data de cadastro
    @GetMapping("buscarpeladata")
    public ResponseEntity<Map<String, Object>> buscarCoordenadoresPeloPeriodo(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicio,
                                                                               @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFim) {
        List<Coordenador> coordenadores = buscarCoordenadoresEntreDatasUseCaseUseCase.execute(dataInicio, dataFim);
        Map<String, Object> response = new HashMap<>();
        // Verificar se a lista está vazia
        if (coordenadores.isEmpty()) {
            response.put("message", "Nenhum coordenador foi encontrado no período informado.");
            response.put("dataInicio", dataInicio);
            response.put("dataFim", dataFim);
            response.put("total", 0);
            response.put("dados", List.of()); // Lista vazia
            return ResponseEntity.ok(response);
        }

        // Se encontrou coordenadores
        List<CoordenadorDto> coordenadoresDto = coordenadores.stream()
                .map(coordenador -> coordenadorDtoMapper.toDto(coordenador, null))
                .toList();

        response.put("message", "Coordenadores encontrados com sucesso!");
        response.put("dataInicio", dataInicio);
        response.put("dataFim", dataFim);
        response.put("total", coordenadoresDto.size());
        response.put("dados", coordenadoresDto);

        return ResponseEntity.ok(response);
    }

    // Endpoint para listar coordenadores pela entidadeId
    @GetMapping("buscarpelaentidadeid")
    public List<CoordenadorDto> buscarCoordenadorPelaEntidadeId(@RequestParam Long entidadeId) {
        List<Coordenador> coordenadores = buscarCoordenadorPelaEntidadeIdUseCase.execute(entidadeId);
        return coordenadores.stream()
                .map(coordenador -> coordenadorDtoMapper.toDto(coordenador, null)) // Converte cada coordenador para DTO sem incluir senha
                .toList();
    }

    // Endpoint para listar coordenadores pelo email
    @GetMapping("buscarpeloemail")
    public ResponseEntity<Map<String, Object>> buscarCoordenadoresPeloEmail(@RequestParam String email) {
        List<Coordenador> coordenadores = buscarCoordenadoresPeloEmailUseCase.execute(email);
        Map<String, Object> response = new HashMap<>();

        // Verificar se a lista está vazia
        if (coordenadores.isEmpty()) {
            response.put("message", "Nenhum coordenador foi encontrado com este email.");
            response.put("email", email);
            response.put("total", 0);
            response.put("dados", List.of()); // Lista vazia
            return ResponseEntity.ok(response);
        }

        // Se encontrou coordenadores
        List<CoordenadorDto> coordenadoresDto = coordenadores.stream()
                .map(coordenador -> coordenadorDtoMapper.toDto(coordenador, null))
                .toList(); // Converte cada coordenador para DTO sem incluir senha

        response.put("message", "Coordenadores encontrados com sucesso!");
        response.put("email", email);
        response.put("total", coordenadoresDto.size());
        response.put("dados", coordenadoresDto);

        return ResponseEntity.ok(response);
    }

    // Endpoint para buscar coordenador pelo
    @GetMapping("buscarpeloid/{id}")
    public ResponseEntity<Map<String, Object>> buscarPeloId(
            @PathVariable Long id) {
            Coordenador coordenador = buscarCoordenadorPeloId.execute(id);

            CoordenadorDto resposta = coordenadorDtoMapper.toDto(coordenador, null);

            Map<String, Object> response = new HashMap<>();
            response.put("message", "Coordenador encontrado!");
            response.put("dados", resposta);

            return ResponseEntity.ok(response);
    }

    // Endpoint para editar coordenador
    @PutMapping("editar/{id}")
    public ResponseEntity<Map<String, Object>> editarCoordenador(
            @PathVariable Long id,
            @RequestBody CoordenadorDto coordenadorDto) {
        try {
            // Converter DTO para domínio
            Coordenador coordenadorAtualizado = new Coordenador(
                    null,
                    coordenadorDto.getNome(),
                    null,
                    null,
                    coordenadorDto.getSobrenome()
            );

            // Executar use case
            Coordenador coordenadorEditado = editarCoordenadorUseCase.execute(
                    id, coordenadorAtualizado, coordenadorDto.getEmail(), coordenadorDto.getSenha(
                    )
            );

            // Montar resposta
            CoordenadorDto resposta = new CoordenadorDto();
            resposta.setId(coordenadorEditado.getId());
            resposta.setNome(coordenadorEditado.getNome());
            resposta.setSobrenome(coordenadorEditado.getSobrenome());
            resposta.setEmail(coordenadorEditado.getEmail());
            resposta.setEntidadeId(coordenadorEditado.getEntidadeId());
            resposta.setAtualizadoEm(coordenadorEditado.getAtualizadoEm());
            resposta.setCriadoEm(coordenadorEditado.getCriadoEm());

            Map<String, Object> response = new HashMap<>();
            response.put("Message: ", "Coordenador editado com sucesso!");
            response.put("Dados do Coordenador: ", resposta);

            return ResponseEntity.ok(response);

        } catch (IllegalArgumentException e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("Error: ", e.getMessage());
            return ResponseEntity.badRequest().body(errorResponse);

        } catch (RuntimeException e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("Error: ", e.getMessage());
            return ResponseEntity.status(404).body(errorResponse);
        }
    }

    // Endpoint para deletar coordenador
    @DeleteMapping("deletar/{id}")
    public ResponseEntity<Map<String, Object>> deletarCoordenador(@PathVariable Long id) {
        try {
            // Buscar coordenador antes de deletar para pegar os dados
            Coordenador coordenadorDeletado = buscarCoordenadorPeloId.execute(id);

            deletarCoordenadorUseCase.execute(id);

            // Contar total após deleção
            long totalCoordenadores = contarTotalCoordenadoresUseCase.execute();

            Map<String, Object> response = new HashMap<>();
            response.put("message", "Coordenador deletado com sucesso!");
            response.put("coordenadorDeletado", Map.of(
                    "id", id,
                    "nome", coordenadorDeletado.getNome() + " " + coordenadorDeletado.getSobrenome(),
                    "email", coordenadorDeletado.getEmail()
            ));
            response.put("total de Coordenadores: ", totalCoordenadores);

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
}
