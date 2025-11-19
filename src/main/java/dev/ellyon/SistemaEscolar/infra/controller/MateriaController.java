package dev.ellyon.SistemaEscolar.infra.controller;

import dev.ellyon.SistemaEscolar.core.entities.Coordenador;
import dev.ellyon.SistemaEscolar.core.entities.Materia;
import dev.ellyon.SistemaEscolar.core.usecase.MateriaUseCases.BuscarTodasMateriasUseCase;
import dev.ellyon.SistemaEscolar.core.usecase.MateriaUseCases.CriarMateriaUseCase;
import dev.ellyon.SistemaEscolar.infra.dtos.CoordenadorDto;
import dev.ellyon.SistemaEscolar.infra.dtos.MateriaDto;
import dev.ellyon.SistemaEscolar.infra.mapper.MateriaDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/materia/")
public class MateriaController {
    private final MateriaDtoMapper materiaDtoMapper;
    private final CriarMateriaUseCase criarMateriaUseCase;
    private final BuscarTodasMateriasUseCase buscarTodasMateriasUseCase;

    // Constructor Injection
    public MateriaController(MateriaDtoMapper materiaDtoMapper, CriarMateriaUseCase criarMateriaUseCase, BuscarTodasMateriasUseCase buscarTodasMateriasUseCase) {
        this.materiaDtoMapper = materiaDtoMapper;
        this.criarMateriaUseCase = criarMateriaUseCase;
        this.buscarTodasMateriasUseCase = buscarTodasMateriasUseCase;
    }

    // Endpoint para criar uma nova materia
    @PostMapping("criar")
    public ResponseEntity<Map<String, Object>> criarMateria(@RequestBody MateriaDto materiaDto) {
        Materia materiaDominio = materiaDtoMapper.toDomain(materiaDto);

        // Executa o caso de uso para criar um nova materia. Pega o DTO, converte para domínio e passa para o caso de uso pois ele recebe somente a entidade de domínio
        Materia novaMateria = criarMateriaUseCase.execute(materiaDominio);

        // Prepara a resposta
        MateriaDto resposta = new MateriaDto();
        resposta.setIdMateria(novaMateria.getIdMateria());
        resposta.setNome(novaMateria.getNome());
        resposta.setCriadoEm(novaMateria.getCriadoEm());
        resposta.setAtualizadoEm(novaMateria.getAtualizadoEm());
        Map<String, Object> response = new HashMap<>();
        response.put("message: ", "Materia criada com sucesso!");
        response.put("dados da Materia: ", resposta);
        return ResponseEntity.ok(response);
    }


    // Endpoint para listar materias
    @GetMapping("buscartodas")
    public ResponseEntity<Map<String, Object>>buscarTodasMaterias() {
        List<Materia> materias = buscarTodasMateriasUseCase.execute();
        Map<String, Object> response = new HashMap<>();
        // Verificar se a lista está vazia
        if (materias.isEmpty()) {
            response.put("message", "Nenhuma materia foi encontrada.");
            response.put("total", 0);
            response.put("dados", List.of()); // Lista vazia
            return ResponseEntity.ok(response);
        }

        List<MateriaDto> materiaDto = materias.stream()
                .map(materia -> materiaDtoMapper.toDto(materia)) // Converte cada materia para DTO
                .toList();
        response.put("message", "Materias encontradas com sucesso!");
        response.put("total", materiaDto.size());
        response.put("dados", materiaDto);

        return ResponseEntity.ok(response);
    }
}
