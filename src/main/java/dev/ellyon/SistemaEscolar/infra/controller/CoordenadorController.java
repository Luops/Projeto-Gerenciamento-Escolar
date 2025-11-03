package dev.ellyon.SistemaEscolar.infra.controller;


import dev.ellyon.SistemaEscolar.core.entities.Coordenador;
import dev.ellyon.SistemaEscolar.core.usecase.*;
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

    // Constructor Injection
    public CoordenadorController(CriarCoordenadorUseCase criarCoordenadorUseCase, CoordenadorDtoMapper coordenadorDtoMapper, BuscarTodosCoordenadoresUseCase buscarCoordenadorUseCase, BuscarCoordenadoresPeloNomeUseCase buscarCoordenadoresPeloNomeUseCase, BuscarCoordenadoresEntreDatasUseCase buscarCoordenadoresEntreDatasUseCaseUseCase, BuscarCoordenadorPelaEntidadeIdUseCase buscarCoordenadorPelaEntidadeIdUseCase) {
        this.criarCoordenadorUseCase = criarCoordenadorUseCase;
        this.coordenadorDtoMapper = coordenadorDtoMapper;
        this.buscarCoordenadorUseCase = buscarCoordenadorUseCase;
        this.buscarCoordenadoresPeloNomeUseCase = buscarCoordenadoresPeloNomeUseCase;
        this.buscarCoordenadoresEntreDatasUseCaseUseCase = buscarCoordenadoresEntreDatasUseCaseUseCase;
        this.buscarCoordenadorPelaEntidadeIdUseCase = buscarCoordenadorPelaEntidadeIdUseCase;
    }

    // Endpoint para criar um novo coordenador
    /*@PostMapping("criar")
    public CoordenadorDto criarCoordenador(@RequestBody CoordenadorDto coordenadorDto) {
        // Executa o caso de uso para criar um novo coordenador. Pega o DTO, converte para domínio e passa para o caso de uso pois ele recebe somente a entidade de domínio
        Coordenador novoCoordenador = criarCoordenadorUseCase.execute(coordenadorDtoMapper.toDomain(coordenadorDto));
        return coordenadorDtoMapper.toDto(novoCoordenador); // Converte o coordenador criado de volta para DTO
    }*/
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
        response.put("Message: ", "Coordenador criado com sucesso!");
        response.put("Dados do Coordenador: ", resposta);
        return ResponseEntity.ok(response);
    }

    // Endpoint para listar coordenadores
    @GetMapping("buscartodos")
    public List<CoordenadorDto> buscarTodosCoordenadores() {
        List<Coordenador> coordenadores = buscarCoordenadorUseCase.execute();
        return coordenadores.stream()
                .map(coordenador -> coordenadorDtoMapper.toDto(coordenador, null)) // Converte cada coordenador para DTO sem incluir senha
                .toList();
    }

    // Endpoint para listar coordenadores pelo nome
    @GetMapping("buscarpelonome")
    public List<CoordenadorDto> buscarCoordenadoresPeloNome(@RequestParam String nome) {
        List<Coordenador> coordenadores = buscarCoordenadoresPeloNomeUseCase.execute(nome);
        return coordenadores.stream()
                .map(coordenador -> coordenadorDtoMapper.toDto(coordenador, null)) // Converte cada coordenador para DTO sem incluir senha
                .toList();
    }

    // Endpoint para listar coordenadores pela data de cadastro
    @GetMapping("buscarpeladata")
    public List<CoordenadorDto> buscarCoordenadoresPeloPeriodo( @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicio,
                                                                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFim) {
        List<Coordenador> coordenadores = buscarCoordenadoresEntreDatasUseCaseUseCase.execute(dataInicio, dataFim);
        return coordenadores.stream()
                .map(coordenador -> coordenadorDtoMapper.toDto(coordenador, null)) // Converte cada coordenador para DTO sem incluir senha
                .toList();
    }

    // Endpoint para listar coordenadores pelo nome
    @GetMapping("buscarpelaentidadeid")
    public List<CoordenadorDto> buscarCoordenadorPelaEntidadeId(@RequestParam Long entidadeId) {
        List<Coordenador> coordenadores = buscarCoordenadorPelaEntidadeIdUseCase.execute(entidadeId);
        return coordenadores.stream()
                .map(coordenador -> coordenadorDtoMapper.toDto(coordenador, null)) // Converte cada coordenador para DTO sem incluir senha
                .toList();
    }
}
